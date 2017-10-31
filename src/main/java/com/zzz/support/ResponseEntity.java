package com.zzz.support;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpMessage;

import java.util.List;

/**
 * controller层统一返回的实体
 * Created by hushengjun on 2017/9/14.
 */
@Data
@Builder
public class ResponseEntity {

    private int msgCode;
    private String msgContent;
    private Object content;

}
