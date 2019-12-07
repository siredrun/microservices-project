package com.baijiaxiu.services.cloud.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @description: kpi报表展示字段
 * @author: liuyufeng
 * @date: 2019-08-29 10:53
 */
@Data
@ApiModel(value = "kpi报表", description = "kpi报表")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ReportKpiVO {

    @ApiModelProperty(value = "日期")
    @ExcelIgnore
    private String date;

    @ApiModelProperty(value = "城市名称")
    @ExcelProperty({"名称", "城市"})
    private String cityName;

    @ApiModelProperty(value = "1小时联系及时率")
    @ExcelProperty({"时效", "1小时联系及时率"})
    private String oneHourContactRate;

    @ApiModelProperty(value = "城市id")
    @ExcelIgnore
    private Integer cityId;

    @ApiModelProperty(value = "普通上门及时率")
    @ExcelProperty({"时效", "普通上门及时率"})
    private String ordinaryVisitTimeRate;

    @ApiModelProperty(value = "紧急3小时上门率")
    @ExcelProperty({"时效", "紧急3小时上门率"})
    private String emergencyThreeHourHomeRate;

    @ApiModelProperty(value = "48小时完成率")
    @ExcelProperty({"时效", "48小时完成率"})
    private String fortyEightHourCompletionRate;

    @ApiModelProperty(value = "评价率")
    @ExcelProperty({"品质", "评价率"})
    private String evaluationOfRate;

    @ApiModelProperty(value = "5星好评率")
    @ExcelProperty({"品质", "5星好评率"})
    private String fiveStarRate;

    @ApiModelProperty(value = "90天多次维修率")
    @ExcelProperty({"品质", "90天多次维修率"})
    private String ninetyDaysMultipleMaintenanceRate;

    @ApiModelProperty(value = "单均成本")
    @ExcelProperty({"成本", "单均成本"})
    private String singleCost;

    @ApiModelProperty(value = "人效超标率")
    @ExcelProperty({"规模", "人效超标率"})
    private String humanEffectRate;

    @ApiModelProperty(value = "创建时间")
    @ExcelIgnore
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @ExcelIgnore
    private Date modifyTime;


}
