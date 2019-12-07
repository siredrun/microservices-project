package com.baijiaxiu.services.cloud.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 时效报表
 * </p>
 *
 * @author liuyufeng
 * @since 2019-09-04
 */
@Data
@ApiModel(value = "时效报表", description = "时效报表")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ReportEffectVO implements Serializable {

    @ApiModelProperty(value = "主键(日期）")
    @ExcelIgnore
    private String date;

    @ApiModelProperty(value = "城市名称")
    @ExcelProperty({"名称", "城市"})
    private String cityName;

    @ApiModelProperty(value = "城市id")
    @ExcelIgnore
    private Integer cityId;

    @ApiModelProperty(value = "创建总单量")
    @ExcelProperty({"联系时效", "创建总单量"})
    private Integer orderNum;

    @ApiModelProperty(value = "联系单量")
    @ExcelProperty({"联系时效", "联系单量"})
    @ExcelIgnore
    private String contactNum;

    @ApiModelProperty(value = "1小时联系及时率")
    @ExcelProperty({"联系时效", "1小时联系及时率"})
    private String contactOntime;

    @ApiModelProperty(value = "1小时联系及时率环比")
    @ExcelProperty({"联系时效", "1小时联系及时率环比"})
    private String contactOntimeRingRatio;

    @ApiModelProperty(value = "紧急单量")
    @ExcelProperty({"紧急3h上门时效", "紧急工单"})
    private String exigencyNum;

    @ApiModelProperty(value = "紧急3小时上门率")
    @ExcelProperty({"紧急3h上门时效", "紧急3h上门率"})
    private String visitOntimeExigency;

    @ApiModelProperty(value = "紧急3小时上门率环比")
    @ExcelProperty({"紧急3h上门时效", "紧急3h上门率环比"})
    private String visitOntimeExigencyRingRatio;

    @ApiModelProperty(value = "一次上门及时率")
    @ExcelProperty({"上门时效", "一次上门及时率"})
    private String visitOntimeFirst;

    @ApiModelProperty(value = "一次上门及时率环比")
    @ExcelProperty({"上门时效", "一次上门及时率环比"})
    private String visitOntimeFirstRingRatio;

    @ApiModelProperty(value = "上门及时率")
    @ExcelProperty({"上门时效", "上门及时率"})
    private String visitOntimeChange;

    @ApiModelProperty(value = "上门及时率环比")
    @ExcelProperty({"上门时效", "上门及时率环比"})
    private String visitOntimeChangeRingRatio;

    @ApiModelProperty(value = "上门单量")
    @ExcelProperty({"4h反馈时效", "上门单量"})
    private String visitNum;

    @ApiModelProperty(value = "4小时反馈率")
    @ExcelProperty({"4h反馈时效", "4小时反馈率"})
    private String feedbackOntime;

    @ApiModelProperty(value = "4小时反馈率环比")
    @ExcelProperty({"4h反馈时效", "4h反馈率环比"})
    private String feedbackOntimeRingRatio;

    @ApiModelProperty(value = "完成单量")
    @ExcelProperty({"完成时效", "完成单量"})
    private String finishNum;

    @ApiModelProperty(value = "24小时完成率")
    @ExcelProperty({"完成时效", "24小时完成率"})
    private String twentyFourFinishrate;

    @ApiModelProperty(value = "24小时完成率环比")
    @ExcelProperty({"完成时效", "24小时完成率环比"})
    private String twentyFourFinishrateRingRatio;

    @ApiModelProperty(value = "48小时完成率")
    @ExcelProperty({"完成时效", "48h完成率"})
    private String fortyEightFinishrate;

    @ApiModelProperty(value = "48小时完成率环比")
    @ExcelProperty({"完成时效", "48h完成率环比"})
    private String fortyEightFinishrateRingRatio;

    @ApiModelProperty(value = "完成率")
    @ExcelProperty({"完成时效", "完成率"})
    private String finishRate;

    @ApiModelProperty(value = "创建时间")
    @ExcelIgnore
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @ExcelIgnore
    private Date modifyTime;
}
