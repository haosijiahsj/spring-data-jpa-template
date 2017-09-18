package com.zzz.support;

import java.util.List;

/**
 * Created by hushengjun on 2017/9/14.
 */
public class ResponseEntity<T> {
    private int msgCode;
    private String msgContent;
    private T content;

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

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
