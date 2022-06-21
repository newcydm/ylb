package com.cydm.money.common.util;

/**
 * 快钱拼接参数工具
 */
public class ParamsUtil {

    public static String appendParam(String returns, String paramId, String paramValue) {
        if (returns != "") {
            if (paramValue != "") {
                returns += "&" + paramId + "=" + paramValue;
            }
        } else {
            if (paramValue != "") {
                returns = paramId + "=" + paramValue;
            }
        }
        return returns;
    }
}