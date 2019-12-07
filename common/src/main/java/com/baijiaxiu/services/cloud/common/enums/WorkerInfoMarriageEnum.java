package com.baijiaxiu.services.cloud.common.enums;

import lombok.Getter;

/**
 * @author hujinming
 * 婚姻状况表
 */
@Getter
public enum WorkerInfoMarriageEnum {
    /**
     * 已婚
     */
    MARRIED(1,"已婚"),

    /**
     * 未婚
     */
    UNMARRIED(2,"未婚"),
    /**
     * 离婚
     */
    DIVORCE(3,"离婚"),
    /**
     * 丧偶
     */
    DEATH_OF_A_SPOUSE(4,"丧偶");


    private Integer code;
    private String message;

    WorkerInfoMarriageEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    /**
     * 通过 val 值索引 WorkerEnum
     *
     * @param code code
     * @return WorkerEnum
     */
    public static WorkerInfoMarriageEnum getEnum(Integer code) {
        for (WorkerInfoMarriageEnum workerInfoMarriageEnum : WorkerInfoMarriageEnum.values()) {
            if (workerInfoMarriageEnum.getCode().equals(code)) {
                return workerInfoMarriageEnum;
            }
        }
        throw new IllegalArgumentException("param value " + code);
    }
}
