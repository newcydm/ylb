package com.cydm.money.common.util;
import com.alibaba.fastjson.JSON;
import com.cydm.money.common.config.BillConfig;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.SocketTimeoutException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;

public class BillQuery {
    private static PoolingHttpClientConnectionManager connManager;
    private static RequestConfig requestConfig;

    public static String gateWayInitQuery(String orderId){
        Map<String, Object> request = new HashMap<String, Object>();
        //固定值：1代表UTF-8;
        String inputCharset = BillConfig.inputCharset;
        //固定值：v2.0 必填
        String version = BillConfig.version;
        //1代表Md5，2 代表PKI加密方式  必填
        String signType = "2";
        //人民币账号 membcode+01  必填
        String merchantAcctId = BillConfig.merchantAcctId;//1001293267101（XIXMFISFG7RGDKQN） 1001217486601(5B5EQDQH2X7ERM9A)
        //固定值：0 按商户订单号单笔查询，1 按交易结束时间批量查询必填
        String queryType = "0";
        //固定值：1	代表简单查询 必填
        String queryMode = "1";

        //数字串，格式为：年[4 位]月[2 位]日[2 位]时[2 位]分[2 位]秒[2位]，例如：20071117020101
        String startTime = "";//20200525000000
        ////数字串，格式为：年[4 位]月[2 位]日[2 位]时[2 位]分[2 位]秒[2位]，例如：20071117020101
        String endTime = "";	//	20200527180000

        String requestPage = "";

//        String orderId = "W02012011000000112";	// 20200526180806TS

        String key = "27YKWKBKHT2IZSQ4";//XIXMFISFG7RGDKQN

        request.put("inputCharset", inputCharset);
        request.put("version", version);
        request.put("signType", signType);
        request.put("merchantAcctId", merchantAcctId);
        request.put("queryType", queryType);
        request.put("queryMode", queryMode);
        request.put("startTime", startTime);
        request.put("endTime", endTime);
        request.put("requestPage", requestPage);
        request.put("orderId", orderId);

        String message="";
        message = ParamsUtil.appendParam(message,"inputCharset",inputCharset);
        message = ParamsUtil.appendParam(message,"version",version);
        message = ParamsUtil.appendParam(message,"signType",signType);
        message = ParamsUtil.appendParam(message,"merchantAcctId",merchantAcctId);
        message = ParamsUtil.appendParam(message,"queryType",queryType);
        message = ParamsUtil.appendParam(message,"queryMode",queryMode);
        message = ParamsUtil.appendParam(message,"startTime",startTime);
        message = ParamsUtil.appendParam(message,"endTime",endTime);
        message = ParamsUtil.appendParam(message,"requestPage",requestPage);
        message = ParamsUtil.appendParam(message,"orderId",orderId);
        message = ParamsUtil.appendParam(message,"key",key);


        String sign = Pkipair.signMsg(message);




        request.put("signMsg", sign);



        //sandbox提交地址
        String reqUrl = "https://sandbox.99bill.com/gatewayapi/gatewayOrderQuery.do";

        String response = "";

        try {

            response = BillQuery.doPostJsonRequestByHttps(JSON.toJSONString(request), reqUrl, 6000, 6000);

            Map<String,Object> m = new HashMap<String, Object>();
            m = JSON.parseObject(response, Map.class);

            return response;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static{
        try {
            SSLContext sslcontext = createIgnoreVerifySSL();
            SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(null, null, null);
            SSLContext.setDefault(sslContext);
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
                    .<ConnectionSocketFactory> create().register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", new SSLConnectionSocketFactory(sslcontext)).build();
            connManager = new PoolingHttpClientConnectionManager(
                    socketFactoryRegistry);
            // 连接池超时时间使用connect超时时间
            requestConfig = RequestConfig.custom()
                    .setConnectionRequestTimeout(1000)
                    .setConnectTimeout(1000)
                    .setSocketTimeout(5000).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 绕过验证
     *
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    private static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance("TLSv1.2");
        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
        X509TrustManager trustManager = new X509TrustManager() {

            public void checkClientTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                                           String paramString) throws CertificateException {}


            public void checkServerTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                                           String paramString) throws CertificateException {}


            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        sc.init(null, new TrustManager[] { trustManager }, null);
        return sc;
    }

    private static String doPostJsonRequestByHttps(String reqeustString, String url,
                                                  int connectTimeout, int socketTimeOut) {
        long startTime = System.currentTimeMillis();
        CloseableHttpResponse response = null;
        String responseString = null;
        try {

            changeRequestConfig(connectTimeout,socketTimeOut);
            CloseableHttpClient httpsClient = HttpClients.custom().setConnectionManager(connManager).build();
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
            httpPost.setConfig(requestConfig);
            httpPost.setEntity(new StringEntity(reqeustString, ContentType.APPLICATION_JSON));
            response = httpsClient.execute(httpPost);
            // get http status code
            int resStatu = response.getStatusLine().getStatusCode();
            responseString = null;
            if (resStatu == HttpStatus.SC_OK) {
                responseString = EntityUtils.toString(response.getEntity());
            } else {
                throw new Exception(url + ",the statusCode is " + resStatu);
            }

            return responseString;
        }catch (ConnectTimeoutException e) {
            e.printStackTrace();
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                    response.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return responseString;
    }

    /**
     * 修改默认超时时间
     * @param connectionTime
     * @param soTimeout
     */
    private static void changeRequestConfig(int connectionTime,int soTimeout){
        if(connectionTime != requestConfig.getConnectionRequestTimeout()
                || soTimeout != requestConfig.getSocketTimeout()){
            requestConfig = RequestConfig.custom()
                    .setConnectionRequestTimeout(connectionTime)
                    .setConnectTimeout(connectionTime)
                    .setSocketTimeout(soTimeout).build();
        }
    }
}
