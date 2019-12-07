package com.baijiaxiu.services.cloud.common.enums;

import lombok.Getter;

/**
 * @author hujinming
 *  等级
 */
@Getter
public enum WorkerLevelEnum {
    /**
     * A级
     */
    A(1,"A"),

    /**
     * B级
     */

    B(2,"B"),
    /**
     * C级
     */
    C(3,"C"),

    /**
     * D级
     */
    D(4,"D");


    private Integer code;
    private String message;

    WorkerLevelEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    /**
     * 通过 val 值索引 WorkerEnum
     *
     * @param code code
     * @return WorkerEnum
     */
    public static WorkerLevelEnum getEnum(Integer code) {
        for (WorkerLevelEnum workerBusinessEnum : WorkerLevelEnum.values()) {
            if (workerBusinessEnum.getCode().equals(code)) {
                return workerBusinessEnum;
            }
        }
        throw new IllegalArgumentException("param value " + code);
    }

}
