package com.baijiaxiu.services.cloud.common.enums;

import lombok.Getter;

/**
 * @author hujinming
 * 征信数据
 */
@Getter
public enum WorkerCreditEnum {


    /**
     * 征信中
     */
    In_the_inquiry(1,"征信中"),

    /**
     * 通过
     */
    THROUGH(2,"通过"),

    /**
     * 拒绝
     */

    REFUSED_TO(3,"拒绝");

    private Integer code;
    private String message;

    WorkerCreditEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    /**
     * 通过 val 值索引 WorkerEnum
     *
     * @param code code
     * @return WorkerEnum
     */
    public static WorkerCreditEnum getEnum(Integer code) {
        for (WorkerCreditEnum workerCreditEnum : WorkerCreditEnum.values()) {
            if (workerCreditEnum.getCode().equals(code)) {
                return workerCreditEnum;
            }
        }
        throw new IllegalArgumentException("param value " + code);
    }
}
