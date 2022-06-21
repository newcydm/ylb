package com.cydm.money.web.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.cydm.money.common.config.BillConfig;
import com.cydm.money.common.constant.Constants;
import com.cydm.money.common.config.AlipayConfig;
import com.cydm.money.common.constant.UserConstants;
import com.cydm.money.common.util.ParamsUtil;
import com.cydm.money.common.util.Pkipair;
import com.cydm.money.model.RechargeRecord;
import com.cydm.money.model.User;
import com.cydm.money.service.BidInfoService;
import com.cydm.money.service.FinanceAccountService;
import com.cydm.money.service.IncomeRecordService;
import com.cydm.money.service.RechargeRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
@RequestMapping("/loan")
public class UserController {
    @Reference(interfaceClass = BidInfoService.class,version = "1.0.0",check = false)
    private BidInfoService bidInfoService;

    @Reference(interfaceClass = RechargeRecordService.class,version = "1.0.0",check = false)
    private RechargeRecordService rechargeRecordService;

    @Reference(interfaceClass = IncomeRecordService.class,version = "1.0.0",check = false)
    private IncomeRecordService incomeRecordService;

    @Reference(interfaceClass = FinanceAccountService.class,version = "1.0.0",check = false)
    private FinanceAccountService financeAccountService;
    //个人中心
    @GetMapping("/myCenter")
    public String myCenter(HttpSession session, Model model){
        User user = (User) session.getAttribute(Constants.SESSION_USER);
        session.setAttribute(UserConstants.BALANCE,financeAccountService.queryByUser(user.getId()));
        model.addAttribute(UserConstants.RECHARGES,rechargeRecordService.queryRechargeAll(1, 5, user.getId()).get(UserConstants.RECHARGES));
        model.addAttribute(UserConstants.INVEST,bidInfoService.queryByUserInfoAll(1, 5, user.getId()).get(UserConstants.INVEST));
        model.addAttribute(UserConstants.EARNINGS,incomeRecordService.queryEarnings(1,5,user.getId()).get(UserConstants.EARNINGS));
        return "myCenter";
    }

    //个人账户
    @GetMapping("/myAccount")
    public String myAccount(){
        return "myAccount";
    }

    //充值
    @GetMapping("/page/toRecharge")
    public String toRecharge(){
        return "toRecharge";
    }

    //个人资料设置
    @GetMapping("/uploadHeader")
    public String uploadHeader(){
        return "uploadHeader";
    }

    //查看全部投资
    @GetMapping("/myInvest")
    public String myInvest(Integer page,Integer pages,HttpSession session,Model model){
        page=page==null?1:page;
        pages=pages==null?5:pages;

        User user = (User) session.getAttribute(Constants.SESSION_USER);

        Map<String, Object> map = bidInfoService.queryByUserInfoAll(page, pages, user.getId());

        Integer rows= (Integer) map.get("rows");

        model.addAttribute(UserConstants.INVEST,map.get(UserConstants.INVEST));
        model.addAttribute("page",page);
        model.addAttribute("rows",rows);
        model.addAttribute("pageSize",rows%pages==0?rows/pages:rows/pages+1);

        return "myInvest";
    }

    //查看全部充值
    @GetMapping("/myRecharge")
    public String myRecharge(Integer page,Integer pages,HttpSession session,Model model){
        page=page==null?1:page;
        pages=pages==null?5:pages;

        User user = (User) session.getAttribute(Constants.SESSION_USER);


        Map<String, Object> map = rechargeRecordService.queryRechargeAll(page, pages, user.getId());

        Integer rows= (Integer) map.get("rows");
        model.addAttribute(UserConstants.RECHARGES,map.get(UserConstants.RECHARGES));
        model.addAttribute("rows",rows);
        model.addAttribute("page",page);
        model.addAttribute("pageSize",rows%pages==0?rows/pages:rows/pages+1);


        return "myRecharge";
    }

    //查看全部收益计划
    @GetMapping("/myIncome")
    public String myIncome(Integer page,Integer pages,Model model,HttpSession session){
        page=page==null?1:page;
        pages=pages==null?5:pages;

        User user = (User) session.getAttribute(Constants.SESSION_USER);


        Map<String, Object> map = incomeRecordService.queryEarnings(page, pages, user.getId());

        Integer rows= (Integer) map.get("rows");
        model.addAttribute(UserConstants.EARNINGS,map.get(UserConstants.EARNINGS));
        model.addAttribute("rows",rows);
        model.addAttribute("page",page);
        model.addAttribute("pageSize",rows%pages==0?rows/pages:rows/pages+1);
        return "myIncome";
    }

    //用户充值
    @PostMapping("/toRecharge")
    public void toRecharge(int payType,RechargeRecord rechargeRecord,HttpSession session,HttpServletResponse resp) throws  IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        User user = (User) session.getAttribute(Constants.SESSION_USER);
        Date date=new Date();
        rechargeRecord.setUid(user.getId());
        rechargeRecord.setRechargeNo(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
        rechargeRecord.setRechargeStatus(0+"");

        rechargeRecord.setRechargeTime(date);



        if(payType==1){//跳转到支付宝页面
            rechargeRecord.setRechargeDesc("支付宝充值");
            rechargeRecordService.recharge(rechargeRecord);
            AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
            AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
            alipayRequest.setReturnUrl(AlipayConfig.return_url);
            alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
            alipayRequest.setBizContent("{\"out_trade_no\":\""+ rechargeRecord.getRechargeNo() +"\","
                    + "\"total_amount\":\""+ rechargeRecord.getRechargeMoney() +"\","
                    + "\"subject\":\""+ "盈利宝" +"\","
                    + "\"body\":\""+ rechargeRecord.getRechargeDesc() +"\","
                    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
            String result= null;
            try {
                result = alipayClient.pageExecute(alipayRequest).getBody();
            } catch (AlipayApiException e) {
                e.printStackTrace();
            }
            resp.getWriter().println(result);

        }else{//跳转到快钱支付
            rechargeRecord.setRechargeDesc("快钱充值");
            rechargeRecordService.recharge(rechargeRecord);
            String signMsgVal = "";
            signMsgVal = ParamsUtil.appendParam(signMsgVal, "inputCharset", BillConfig.inputCharset);
            signMsgVal = ParamsUtil.appendParam(signMsgVal, "pageUrl", BillConfig.pageUrl);
            signMsgVal = ParamsUtil.appendParam(signMsgVal, "bgUrl", BillConfig.bgUrl);
            signMsgVal = ParamsUtil.appendParam(signMsgVal, "version", BillConfig.version);
            signMsgVal = ParamsUtil.appendParam(signMsgVal, "language", BillConfig.language);
            signMsgVal = ParamsUtil.appendParam(signMsgVal, "signType", BillConfig.signType);
            signMsgVal = ParamsUtil.appendParam(signMsgVal, "merchantAcctId", BillConfig.merchantAcctId);
            signMsgVal = ParamsUtil.appendParam(signMsgVal, "orderId", rechargeRecord.getRechargeNo());
            signMsgVal = ParamsUtil.appendParam(signMsgVal, "orderAmount", rechargeRecord.getRechargeMoney().intValue()*100+"");
            signMsgVal = ParamsUtil.appendParam(signMsgVal, "orderTime",new SimpleDateFormat("yyyyMMddHHmmss").format(date));
            signMsgVal = ParamsUtil.appendParam(signMsgVal, "payType", BillConfig.payType);
            signMsgVal = ParamsUtil.appendParam(signMsgVal, "bankId", BillConfig.bankId);
            signMsgVal = ParamsUtil.appendParam(signMsgVal, "redoFlag", BillConfig.redoFlag);
            signMsgVal = ParamsUtil.appendParam(signMsgVal, "pid", BillConfig.pid);
            String signMsg=URLEncoder.encode(Pkipair.signMsg(signMsgVal),"UTF-8");
            signMsgVal=ParamsUtil.appendParam(signMsgVal,"signMsg",signMsg);
            resp.sendRedirect("https://sandbox.99bill.com/gateway/recvMerchantInfoAction.htm?bgUrl=&bankId=&pid=&"+signMsgVal);
        }
    }

    //支付宝充值返回状态
    @RequestMapping("/page/AliReturn")
    public String AliReturn(HttpServletRequest request,Double total_amount,Model model,HttpSession session) throws UnsupportedEncodingException, AlipayApiException {
        //获取支付宝GET过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();

        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }


        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

        //——请在这里编写您的程序（以下代码仅作参考）——
        if(signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
            //设置请求参数
            AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();
            alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"}");
            //请求并返回JSON对象
            JSONObject result = JSON.parseObject(alipayClient.execute(alipayRequest).getBody());
            JSONObject jsonObject = result.getJSONObject("alipay_trade_query_response");
            String code = jsonObject.getString("code");

            RechargeRecord rechargeRecord=new RechargeRecord();
            rechargeRecord.setRechargeNo(out_trade_no);
            rechargeRecord.setRechargeMoney(total_amount);

            if("10000".equals(code)){//和查询api通讯状态
                String trade_status = jsonObject.getString("trade_status");
                if("TRADE_SUCCESS".equals(trade_status)||"TRADE_FINISHED".equals(trade_status)){
                    User user = (User) session.getAttribute(Constants.SESSION_USER);
                    rechargeRecord.setUid(user.getId());
                    //修改session数据
                    session.setAttribute(UserConstants.BALANCE,(Double)session.getAttribute(UserConstants.BALANCE)+rechargeRecord.getRechargeMoney());
                    rechargeRecordService.paymentSuccess(rechargeRecord);
                    return "close";
                }else{
                    rechargeRecordService.paymentFailure(rechargeRecord);
                    model.addAttribute(UserConstants.TRADE_MSG,"支付失败");
                }

            }else{
                model.addAttribute(UserConstants.TRADE_MSG,"网络繁忙,请稍后在查看结果");
            }

        }else {
            model.addAttribute(UserConstants.TRADE_MSG,"验签失败");
        }
        return "toRechargeBack";
    }

    //快钱充值返回状态
    @RequestMapping("/page/BillReturn")
    public String BillReturn(int payResult,String orderId,int orderAmount,HttpSession session){
        RechargeRecord rechargeRecord=new RechargeRecord();
        rechargeRecord.setRechargeNo(orderId);
        rechargeRecord.setRechargeMoney((double)(orderAmount/100));
        if(payResult==10){
            User user=(User)session.getAttribute(Constants.SESSION_USER);
            rechargeRecord.setUid(user.getId());
            //修改session数据
            session.setAttribute(UserConstants.BALANCE,(Double)session.getAttribute(UserConstants.BALANCE)+rechargeRecord.getRechargeMoney());
            rechargeRecordService.paymentSuccess(rechargeRecord);
        }else if(payResult==11){
            rechargeRecordService.paymentFailure(rechargeRecord);
        }
        return "redirect:../myRecharge";
    }
}
