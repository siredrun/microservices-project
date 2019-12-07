package com.baijiaxiu.services.cloud.common.enums;

import lombok.Getter;

/**
 * @author hujinming
 * 性别
 */
@Getter
public enum WorkerInfoGenderEnum {

    /**
     * 男
     */
    MALE(1,"男"),

    /**
     * 女
     */
    FEMALE(3,"女");


    private Integer code;
    private String message;

    WorkerInfoGenderEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    /**
     * 通过 val 值索引 WorkerEnum
     *
     * @param code code
     * @return WorkerEnum
     */
    public static WorkerInfoGenderEnum getEnum(Integer code) {
        for (WorkerInfoGenderEnum workerInfoGenderEnum : WorkerInfoGenderEnum.values()) {
            if (workerInfoGenderEnum.getCode().equals(code)) {
                return workerInfoGenderEnum;
            }
        }
        throw new IllegalArgumentException("param value " + code);
    }
}
