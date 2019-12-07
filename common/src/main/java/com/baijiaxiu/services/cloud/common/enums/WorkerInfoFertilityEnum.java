package com.baijiaxiu.services.cloud.common.enums;

import lombok.Getter;

/**
 * @author hujinming
 * 生育情况
 */
@Getter
public enum WorkerInfoFertilityEnum {

    /**
     * 已育
     */
    WITH_CHILDREN(1,"已育"),

    /**
     * 未育
     */
    CHILDLESS(2,"未育");


    private Integer code;
    private String message;

    WorkerInfoFertilityEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }



    /**
     * 通过 val 值索引 WorkerEnum
     *
     * @param code code
     * @return WorkerEnum
     */
    public static WorkerInfoFertilityEnum getEnum(Integer code) {
        for (WorkerInfoFertilityEnum workerInfoFertility : WorkerInfoFertilityEnum.values()) {
            if (workerInfoFertility.getCode().equals(code)) {
                return workerInfoFertility;
            }
        }
        throw new IllegalArgumentException("param value " + code);
    }



}

