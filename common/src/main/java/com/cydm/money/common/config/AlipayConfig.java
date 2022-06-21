package com.cydm.money.common.config;

/**
 * 阿里支付接口配置
 */
public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000120697560";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCzPTMaajkmK8qb3eC2GmV20gLf/DrZmKV4s5Ucu5NrPzzmyfXU1BrsjSe8I9uZIrkv5rgLZ3lSZXmamuuFaR9TVrGDdAvNQRpCwLRQCyGNPl8aN1wYLsQMY/1aQrIbfiYAXyyLh2LShPY5G5iteqEs4rt2nN9eZDDx2DbgTD9rqkTkhBBMBxNEBLNBZp7Om42EzH5nP/w0vxO+cXEnWH+ZrGTk/RmktQpulZzJ342F1wm2vCIx2Ujlzv9sCsmTmxHJDzLwVjWLughqlvzMa8gNgvg3E7oDYbCV6IIgg2XeZ1lP/J1WjbSBBbqe+6oh8gg2bptFG0yDASkKRITkcSA5AgMBAAECggEAJeXdxUsKdGC0AUrjtX1VUM9M3lE1nEajTicicyXSIM4JMX8oZGzImJWr/iLSzslBwLgW2Apz45EjKiZxgA7fGb7t366MxERsqgqW1YnU+Ulj0GY+KbrRpxEJQ6lwgVGl9VQqVgI1Se/lI+QK3ztbkuMJ4iV/MTUcCDbAO6LDkh7err7TkyB2UBtmjMPTgIS4+qU1oyRyktY8ntpvOEBcuioHy9eUVMWMlMOEhX5itGkKZgFeg0eFFTojvjWFCsmnbuW4YUzJHIZMQ1zRdh8Oi9U8NLHMTD/2Vm7pY1NHWF5TTqgplSpuw6tOuyBYeqjILedjCXL2r62VmL+aIDlSpQKBgQDgH7PVf5yA12e8JZbRNCTUyuCEk4Q7tdNPU6PUZxaGRbp5PdAQnExVABZZDQc8zJfJioXEhY7pyKp4YWphILKM10xh/rA7E/AnoPuOqkwONkVXteoPlTrICsldIFBhzPQLe9pF9ftOE12oK6X9miGrHf5bDIGqKgaQ8G/yig4gYwKBgQDMu0CyLlk3Y+q/uCKjMr6Fv6B79FIaHCRKX6AI2cKX3Zo0aFsgMXrYFXeS7/Jqf8vc7WKaQdJkWMYkaytGiumDSjtuN14kaueD1J3MVeEyON0UNguzTA/XaQzbsJ4eQMBBhmdSA3qf9K9Jxfzf7R9v6IFgs8AmnM/blPCxK+8JswKBgAD4ojLeprL4O/7YutqVO0OgzXBFo2EO3KePWTpmZ/aU/sXfurMXukzz/yTLpahhypaY/xNm8MOalwKGiYt6NMvfcvlJvUHESFojnHN10XaOTaafpzACGYscYNsCdNa3qKcUFlIPStN/yfwclE+RB2xSaPPEDhvKqtSd9h468uy5AoGAaGA/B5hhm7+w+rVh01oXkBC2PPu+r9kRF2nRKTH753jvGTDq5GrVejzXjW4PZQRqZuQPlR1hqg8oVYDdu0Uu7+R0kChiMqbeCXPoTzipavVaoOc859gra2L/TzGoKzxPyBhBrKphZhNVGoN5/J/jmyYqb6a0m/rubcBtRaZkY8kCgYBje7BhZp8GCDwI/vSJHnt6eqpRS+smfg+DggVYgaUnv52u6UYYhwpNH8Fqohy8sxuMcoA52joWcvWARQQ30ZnvUNCuKw/R5+KOG6Duoe2i9F/5pbirykOsyvm1z1s7R/rr4tAr5aYuqDvBZvrNBTwBvIOH2nCl/9zvq14Ye09tLw==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArY2l/h43dJiCeMKp/Gv7xtX6gKSMn9x2aJ2+KrnpHU0KOj85BjsIvfCVEMdeETps8eQR6ySnHe32IAey5NxTxv9mZpSVW1ufythQOUvBWOTCTJg6PmCIEvryy0Dy25q1haDAadFirwZnAV6BNfwnjvDa/0jUVYWf3lNtADBXR1ypz/lIHB8PsuT1enKYWmxfQG2B6ezokDyMJSEwgcKA5vazEy2pLjkBJjX140jenNekfx9MI89QwLYiYTwfCwxBPpxkxyxLsRqktjsCouEtJ9wRR0bnVGTcm5BnAin15ylACGWyH1BFf8K4yP+sL46yFh5+WDd5RWzG54Ed/nZuvQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8082/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/money/loan/page/AliReturn";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";
}
