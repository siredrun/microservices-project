package com.baijiaxiu.services.cloud.common.enums;

import lombok.Getter;

/**
 * @author hujinming
 * 梯队
 */
@Getter
public enum  WorkerEchelonEnum {
    /**
     * 精英
     */
    ELITE(1,"精英"),
    /**
     * 高潜
     */
    HIGH_DIVE(2,"高潜"),
    /**
     * 一般
     */
    GENERAL(3,"一般"),
    /**
     * 一般
     */
    VERY_GENERAL(4,"一般");

    private Integer code;
    private String message;

    WorkerEchelonEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    /**
     * 通过 val 值索引 WorkerEnum
     *
     * @param code code
     * @return WorkerEnum
     */
    public static WorkerEchelonEnum getEnum(Integer code) {
        for (WorkerEchelonEnum workerEchelonEnum : WorkerEchelonEnum.values()) {
            if (workerEchelonEnum.getCode().equals(code)) {
                return workerEchelonEnum;
            }
        }
        throw new IllegalArgumentException("param value " + code);
    }
}
