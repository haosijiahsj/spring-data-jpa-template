package com.zzz.support;

import lombok.*;
import org.springframework.http.HttpMessage;

import java.io.Serializable;

/**
 * controller层统一返回的实体
 *
 * @author hushengjun
 * @date 2017/9/14
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ResponseEntity implements Serializable {

    private static final long serialVersionUID = 9064531997679501400L;

    private int msgCode;
    private String msgContent;
    private Object result;

    public ResponseEntity(ResponseStatus status) {
        this.msgCode = status.getCode();
        this.msgContent = status.getCodeMsg();
    }

    public ResponseEntity(ResponseStatus status, Object result) {
        this.msgCode = status.getCode();
        this.msgContent = status.getCodeMsg();
        this.result = result;
    }

}
