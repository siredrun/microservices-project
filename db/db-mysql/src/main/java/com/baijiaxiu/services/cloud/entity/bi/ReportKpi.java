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
 * kpi报表
 * </p>
 *
 * @author liuyufeng
 * @since 2019-08-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ReportKpi对象", description = "kpi报表")
public class ReportKpi implements Serializable {

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

    @ApiModelProperty(value = "一小时联系率分子")
    @TableField("one_hour_contact_rate_numerator")
    private Double oneHourContactRateNumerator;

    @ApiModelProperty(value = "一小时联系率分母")
    @TableField("one_hour_contact_rate_denominator")
    private Double oneHourContactRateDenominator;

    @ApiModelProperty(value = "普通上门及时率分子")
    @TableField("ordinary_visit_time_rate_numerator")
    private Double ordinaryVisitTimeRateNumerator;

    @ApiModelProperty(value = "普通上门及时率分母")
    @TableField("ordinary_visit_time_rate_denominator")
    private Double ordinaryVisitTimeRateDenominator;

    @ApiModelProperty(value = "紧急3小时上门率分子")
    @TableField("emergency_three_hour_home_rate_numerator")
    private Double emergencyThreeHourHomeRateNumerator;

    @ApiModelProperty(value = "紧急3小时上门率分母")
    @TableField("emergency_three_hour_home_rate_denominator")
    private Double emergencyThreeHourHomeRateDenominator;

    @ApiModelProperty(value = "48小时完成率分子")
    @TableField("forty_eight_hour_completion_rate_numerator")
    private Double fortyEightHourCompletionRateNumerator;

    @ApiModelProperty(value = "48小时完成率分母")
    @TableField("forty_eight_hour_completion_rate_denominator")
    private Double fortyEightHourCompletionRateDenominator;

    @ApiModelProperty(value = "评价率分子")
    @TableField("evaluation_of_rate_numerator")
    private Double evaluationOfRateNumerator;

    @ApiModelProperty(value = "评价率分母")
    @TableField("evaluation_of_rate_denominator")
    private Double evaluationOfRateDenominator;

    @ApiModelProperty(value = "5星好评率分子")
    @TableField("five_star_rate_numerator")
    private Double fiveStarRateNumerator;

    @ApiModelProperty(value = "5星好评率分母")
    @TableField("five_star_rate_denominator")
    private Double fiveStarRateDenominator;

    @ApiModelProperty(value = "90天多次维修率分子")
    @TableField("ninety_days_multiple_maintenance_rate_numerator")
    private Double ninetyDaysMultipleMaintenanceRateNumerator;

    @ApiModelProperty(value = "90天多次维修率分母")
    @TableField("ninety_days_multiple_maintenance_rate_denominator")
    private Double ninetyDaysMultipleMaintenanceRateDenominator;

    @ApiModelProperty(value = "单均成本分子")
    @TableField("single_cost_numerator")
    private Double singleCostNumerator;

    @ApiModelProperty(value = "单均成本分母")
    @TableField("single_cost_denominator")
    private Double singleCostDenominator;

    @ApiModelProperty(value = "人效超标率分子")
    @TableField("human_effect_rate_numerator")
    private Double humanEffectRateNumerator;

    @ApiModelProperty(value = "人效超标率分母")
    @TableField("human_effect_rate_denominator")
    private Double humanEffectRateDenominator;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("modify_time")
    private Date modifyTime;


}
