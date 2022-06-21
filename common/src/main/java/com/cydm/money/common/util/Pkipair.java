package com.cydm.money.common.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URLDecoder;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/**
 * 快钱支付接口签名和解签工具
 */
public class Pkipair {
    public static String signMsg( String signMsg) {
        String base64 = "";
        try {

            KeyStore ks = KeyStore.getInstance("PKCS12");
            String file = Pkipair.class.getResource("/config/10012140356.pfx").getPath().replaceAll("%20", " ");

            //如果项目执行目录下有中文等特殊符号，则需要base64编码
            file = URLDecoder.decode(file,"UTF-8");

            FileInputStream ksfis = new FileInputStream(file);
            BufferedInputStream ksbufin = new BufferedInputStream(ksfis);
            char[] keyPwd = "123456".toCharArray();
            //char[] keyPwd = "YaoJiaNiLOVE999Year".toCharArray();
            ks.load(ksbufin, keyPwd);
            PrivateKey priK = (PrivateKey) ks.getKey("test-alias", keyPwd);
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(priK);
            signature.update(signMsg.getBytes("utf-8"));
            sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
            base64 = encoder.encode(signature.sign());

        } catch(FileNotFoundException e){

        }catch (Exception ex) {
            ex.printStackTrace();
        }

        return base64;
    }
    
    public static boolean enCodeByCer( String val, String msg) {
        boolean flag = false;
        try {
            String file = Pkipair.class.getResource("/config/CFCA_sandbox.cer").toURI().getPath();//99bill[1].cert.rsa.20140803.cer
            //如果项目执行目录下有中文等特殊符号，则需要base64编码
            file = URLDecoder.decode(file,"UTF-8");
                                 //  99bill.cert.rsa.20140803.cer
            FileInputStream inStream = new FileInputStream(file);
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);
            PublicKey pk = cert.getPublicKey();
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(pk);
            signature.update(val.getBytes());
            sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();

            flag = signature.verify(decoder.decodeBuffer(msg));

        } catch (Exception e) {
            e.printStackTrace();

        }
        return flag;
    }
}