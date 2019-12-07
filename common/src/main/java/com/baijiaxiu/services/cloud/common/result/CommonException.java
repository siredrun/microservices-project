package com.baijiaxiu.services.cloud.common.result;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * description:
 *
 * @author hujinming
 * @date 2019/9/18 15:59
 */
@Getter
@Setter
public class CommonException extends Exception {

    private int statusCode = HttpStatus.BAD_REQUEST.value();
    private int code;
    private Object errors;

    public CommonException() {
        super();
    }
    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }
    public CommonException(Throwable cause) {
        super(cause);
    }
    protected CommonException(String message, Throwable cause,
                              boolean enableSuppression,
                              boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    public CommonException(String message) {
        super(message);
    }
    public CommonException(int statusCode, String message){
        super(message);
        this.statusCode=statusCode;
    }
    public CommonException(int statusCode, String message, Object errors){
        super(message);
        this.statusCode=statusCode;
        this.errors=errors;
    }
    public CommonException(int statusCode, String message, Object errors,int code){
        super(message);
        this.statusCode=statusCode;
        this.errors=errors;
        this.code = code;
    }
}
