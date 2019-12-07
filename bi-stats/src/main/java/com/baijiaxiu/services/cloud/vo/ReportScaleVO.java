package com.baijiaxiu.services.cloud.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @description: 规模报表展示字段
 * @author: liuyufeng
 * @date: 2019-09-02 11:37
 */
@Data
@ApiModel(value = "规模报表", description = "规模报表")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ReportScaleVO {

    @ApiModelProperty(value = "日期")
    @ExcelIgnore
    private String date;

    @ApiModelProperty(value = "城市名称")
    @ExcelProperty("城市")
    private String cityName;

    @ApiModelProperty(value = "城市id")
    @ExcelIgnore
    private Integer cityId;

    @ApiModelProperty(value = "创建单量")
    @ExcelProperty("创建单量")
    private String createOrderQuantity;

    @ApiModelProperty(value = "单量环比")
    @ExcelProperty("单量环比")
    private String quantityRingRatio;

    @ApiModelProperty(value = "紧急占比")
    @ExcelProperty("紧急占比")
    private String emergencyRatio;

    @ApiModelProperty(value = "报修单量")
    @ExcelProperty("报修单量")
    private String repairAmount;

    @ApiModelProperty(value = "完成单量")
    @ExcelProperty("完成单量")
    private String completeSingleQuantity;

    @ApiModelProperty(value = "完成环比")
    @ExcelProperty("完成环比")
    private String completeRingRatio;

    @ApiModelProperty(value = "结算单量")
    @ExcelProperty("结算单量")
    private String billingAmount;

    @ApiModelProperty(value = "结算积压单量")
    @ExcelProperty("结算积压单量")
    private String settlementBacklogAmount;

    @ApiModelProperty(value = "师傅人数")
    @ExcelProperty("师傅人数")
    private String numberMasters;

    @ApiModelProperty(value = "接单人数")
    @ExcelProperty("接单人数")
    private String numberOrders;

    @ApiModelProperty(value = "接单人效")
    @ExcelProperty("接单人效")
    private String orderEffect;

    @ApiModelProperty(value = "完成人效")
    @ExcelProperty("完成人效")
    private String completeHumanEffect;

    @ApiModelProperty(value = "48小时遗留单量")
    @ExcelProperty("48小时遗留单量")
    private String fortyEightHourLegacyAmount;

    @ApiModelProperty(value = "创建时间")
    @ExcelIgnore
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @ExcelIgnore
    private Date modifyTime;

}
