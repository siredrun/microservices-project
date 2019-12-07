package com.baijiaxiu.services.cloud.entity.bi;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 规模报表
 * </p>
 *
 * @author liuyufeng
 * @since 2019-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ReportScale对象", description = "规模报表")
public class ReportScale implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键(日期)")
    @TableId("date")
    private String date;

    @ApiModelProperty(value = "城市名称")
    @TableField("city_name")
    private String cityName;

    @ApiModelProperty(value = "城市id")
    @TableField("city_id")
    private Integer cityId;

    @ApiModelProperty(value = "创建单量")
    @TableField("create_order_quantity")
    private Double createOrderQuantity;

    @ApiModelProperty(value = "紧急占比分子")
    @TableField("emergency_ratio_numerator")
    private Double emergencyRatioNumerator;

    @ApiModelProperty(value = "紧急占比分母")
    @TableField("emergency_ratio_denominator")
    private Double emergencyRatioDenominator;

    @ApiModelProperty(value = "报修单量")
    @TableField("repair_amount")
    private Double repairAmount;

    @ApiModelProperty(value = "完成单量")
    @TableField("complete_single_quantity")
    private Double completeSingleQuantity;

    @ApiModelProperty(value = "结算单量")
    @TableField("billing_amount")
    private Double billingAmount;

    @ApiModelProperty(value = "结算积压单量")
    @TableField("Settlement_backlog_amount")
    private Double settlementBacklogAmount;

    @ApiModelProperty(value = "师傅人数")
    @TableField("number_masters")
    private Double numberMasters;

    @ApiModelProperty(value = "接单人数")
    @TableField("number_orders")
    private Double numberOrders;

    @ApiModelProperty(value = "接单人效分子")
    @TableField("order_effect_numerator")
    private Double orderEffectNumerator;

    @ApiModelProperty(value = "接单人效分母")
    @TableField("order_effect_denominator")
    private Double orderEffectDenominator;

    @ApiModelProperty(value = "完成人效分子")
    @TableField("complete_human_effect_numerator")
    private Double completeHumanEffectNumerator;

    @ApiModelProperty(value = "完成人效分母")
    @TableField("complete_human_effect_denominator")
    private Double completeHumanEffectDenominator;

    @ApiModelProperty(value = "48小时遗留单量")
    @TableField("forty_eight_hour_legacy_amount")
    private Double fortyEightHourLegacyAmount;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("modify_time")
    private Date modifyTime;


}
