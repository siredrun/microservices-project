package com.baijiaxiu.services.cloud.common.enums;

import lombok.Getter;

/**
 * @author hujinming
 *  流程状态
 */
@Getter
public enum  WorkerCourseEnum {

    /**
     *基本信息
     */
    INFORMATION(1,"基本信息"),
    /**
     *技能认证
     */
    SKILLS(2,"技能认证"),

    /**
     * 培训信息
     */
    TRAINING(3,"培训信息"),

    /**
     * 实习信息
     */
    INTERNSHIP(4,"实习信息"),

    /**
     * 在职
     */
    ON_THE_JOB(5,"在职");


    private Integer code;
    private String message;

    WorkerCourseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }



    /**
     * 通过 val 值索引 WorkerEnum
     *
     * @param code code
     * @return WorkerEnum
     */
    public static WorkerCourseEnum getEnum(Integer code) {
        for (WorkerCourseEnum workerCourseEnum : WorkerCourseEnum.values()) {
            if (workerCourseEnum.getCode().equals(code)) {
                return workerCourseEnum;
            }
        }
        throw new IllegalArgumentException("param value " + code);
    }



}
