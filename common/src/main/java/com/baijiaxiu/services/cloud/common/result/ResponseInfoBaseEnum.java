package com.baijiaxiu.services.cloud.common.result;

import lombok.Getter;

/**
 * @description: 应用系统级别的返回码
 * @author: liuyufeng
 * @date: 2019-08-28 11:31
 */
@Getter
public enum ResponseInfoBaseEnum implements ResponseInfo {
    /**
     * 成功
     */
    SUCCESS("200", "success"),

    /**
     * 失败
     */
    ERROR("500", "error"),

    /**
     * 暂无数据
     */
    NO_DATA("501", "暂无数据"),

    /**
     * API接口返回码
     */
    ERROR_41000("41000", "服务异常出错"),

    FAIL_31000("31000", "缺少必要参数");

    private String code;
    private String message;

    ResponseInfoBaseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }


}
