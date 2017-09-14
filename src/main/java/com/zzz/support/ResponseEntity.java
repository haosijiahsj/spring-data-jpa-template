package com.zzz.support;

import java.util.List;

/**
 * Created by hushengjun on 2017/9/14.
 */
public class ResponseEntity<T> {
    private int msgCode;
    private String msgContent;
    private List<T> content;
}
