package com.baijiaxiu.services.cloud.common.enums;


import lombok.Getter;

/**
 * @author hujinming
 * 培训状态
 */
@Getter
public enum  WorkerTrainEnum {

    /**
     *待技能认证
     */
    STAY_SKILLS(1,"待技能认证"),

    /**
     * 待培训
     */
    STAY_TRAINING(2,"待培训"),
    /**
     * 培训中
     */
    IN_THE_TRAINING(3,"培训中"),

    /**
     * 待实习
     */
    STAY_INTERNSHIP(4,"待实习"),

    /**
     * 实习中
     */
    IN_THE_INTERNSHIP(5,"实习中"),

    /**
     *待上岗
     */
    TO_MOUNT_GUARD(6,"在职"),
    /**
     * 在职
     */
    ON_THE_JOB(7,"在职"),

    /**
     *离职
     */
    DEPARTURE(8,"离职"),


    /**
     * 淘汰
     */
    ELIMINATE(9,"淘汰");



    private Integer code;
    private String message;

    WorkerTrainEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }



    /**
     * 通过 val 值索引 WorkerEnum
     *
     * @param code code
     * @return WorkerEnum
     */
    public static WorkerTrainEnum getEnum(Integer code) {
        for (WorkerTrainEnum WorkerEnum : WorkerTrainEnum.values()) {
            if (WorkerEnum.getCode().equals(code)) {
                return WorkerEnum;
            }
        }
        throw new IllegalArgumentException("param value " + code);
    }

}
