package com.zzz.support;

/**
 * Created by hushengjun on 2017/11/2.
 */
public enum ResponseStatus {

    SUCCESS(200, "success"),
    REQUEST_PARAM_EXCEPTION(601, "request parameters exception, check your parameters");

    private int code;
    private String codeMsg;

    ResponseStatus(int code, String codeMsg) {
        this.code = code;
        this.codeMsg = codeMsg;
    }

    public int getCode() {
        return code;
    }

    public String getCodeMsg() {
        return codeMsg;
    }
}
