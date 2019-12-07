package com.baijiaxiu.services.cloud.common.enums;

import lombok.Getter;

/**
 * @author hujinming
 * 学历
 */
@Getter
public enum  WorkInfoEducationEnum {


    /**
     * 大专以下
     */
    COLLEGE_THE_FOLLOWING(1,"大专以下"),


    /**
     * 大专及以上
     */
    JUNIOR_COLLEGE_OR_ABOVE(2,"大专及以上");

    private Integer code;
    private String message;

    WorkInfoEducationEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 通过 val 值索引 WorkerEnum
     *
     * @param code code
     * @return WorkerEnum
     */
    public static WorkInfoEducationEnum getEnum(Integer code) {
        for (WorkInfoEducationEnum workInfoEducationEnum : WorkInfoEducationEnum.values()) {
            if (workInfoEducationEnum.getCode().equals(code)) {
                return workInfoEducationEnum;
            }
        }
        throw new IllegalArgumentException("param value " + code);
    }
}
