package com.zzz.support;

import org.springframework.http.HttpMessage;

import java.util.List;

/**
 * Created by hushengjun on 2017/9/14.
 */
public class ResponseEntity {
    private int msgCode;
    private String msgContent;
    private Object content;

    public int getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(int msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
