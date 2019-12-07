package com.baijiaxiu.services.cloud.enums;

import com.baijiaxiu.services.cloud.vo.*;
import lombok.Getter;

/**
 * @description:
 * @author: liuyufeng
 * @date: 2019-08-29 8:45
 */
@Getter
public enum ReportTypeEnum {
    /**
     * 工单类型
     */
    ORDER_TYPE(1, "工单类型", ReportOrderTypeVO.class),

    /**
     * 品质
     */
    QUALITY(2, "品质", ReportQualityVO.class),

    /**
     * 时效
     */
    AGING(3, "时效", ReportEffectVO.class),

    /**
     * 成本
     */
    COST(4, "成本", ReportCostVO.class),

    /**
     * 规模
     */
    SCALE(5, "规模", ReportScaleVO.class),

    /**
     * kpi
     */
    KPI(6, "kpi", ReportKpiVO.class);


    private Integer code;
    private String message;
    private Class mappingClass;

    ReportTypeEnum(Integer code, String message, Class mappingClass) {
        this.code = code;
        this.message = message;
        this.mappingClass = mappingClass;
    }

    public static ReportTypeEnum getEnum(Integer code) {
        for (ReportTypeEnum sourceEnum : ReportTypeEnum.values()) {
            if (sourceEnum.getCode().equals(code)) {
                return sourceEnum;
            }
        }
        return null;
    }


}
