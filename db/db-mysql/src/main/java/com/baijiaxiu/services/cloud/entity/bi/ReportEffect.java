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
 * 时效报表
 * </p>
 *
 * @author liuyufeng
 * @since 2019-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ReportEffect对象", description = "时效报表")
public class ReportEffect implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键(日期）")
    @TableId("date")
    private String date;

    @ApiModelProperty(value = "城市名称")
    @TableField("city_name")
    private String cityName;

    @ApiModelProperty(value = "城市id")
    @TableField("city_id")
    private Integer cityId;

    @ApiModelProperty(value = "创建总单量")
    @TableField("order_num")
    private Integer orderNum;

    @ApiModelProperty(value = "联系单量")
    @TableField("contact_num")
    private Double contactNum;

    @ApiModelProperty(value = "1小时联系及时分子")
    @TableField("contact_ontime_numerator")
    private Double contactOntimeNumerator;

    @ApiModelProperty(value = "1小时联系及时分母")
    @TableField("contact_ontime_denominator")
    private Double contactOntimeDenominator;

    @ApiModelProperty(value = "紧急单量")
    @TableField("exigency_num")
    private Double exigencyNum;

    @ApiModelProperty(value = "紧急3小时上门率分子")
    @TableField("visit_ontime_exigency_numerator")
    private Double visitOntimeExigencyNumerator;

    @ApiModelProperty(value = "紧急3小时上门率分母")
    @TableField("visit_ontime_exigency_denominator")
    private Double visitOntimeExigencyDenominator;

    @ApiModelProperty(value = "一次上门及时率分子")
    @TableField("visit_ontime_first_numerator")
    private Double visitOntimeFirstNumerator;

    @ApiModelProperty(value = "一次上门及时率分母")
    @TableField("visit_ontime_first_denominator")
    private Double visitOntimeFirstDenominator;

    @ApiModelProperty(value = "上门及时率分子")
    @TableField("visit_ontime_change_numerator")
    private Double visitOntimeChangeNumerator;

    @ApiModelProperty(value = "上门及时率分母")
    @TableField("visit_ontime_change_denominator")
    private Double visitOntimeChangeDenominator;

    @ApiModelProperty(value = "上门单量")
    @TableField("visit_num")
    private Double visitNum;

    @ApiModelProperty(value = "4小时反馈率分子")
    @TableField("feedback_ontime_numerator")
    private Double feedbackOntimeNumerator;

    @ApiModelProperty(value = "4小时反馈率分母")
    @TableField("feedback_ontime_denominator")
    private Double feedbackOntimeDenominator;

    @ApiModelProperty(value = "完成单量")
    @TableField("finish_num")
    private Double finishNum;

    @ApiModelProperty(value = "24小时完成率分子")
    @TableField("twenty_four_finishrate_numerator")
    private Double twentyFourFinishrateNumerator;

    @ApiModelProperty(value = "24小时完成率分母")
    @TableField("twenty_four_finishrate_denominator")
    private Double twentyFourFinishrateDenominator;

    @ApiModelProperty(value = "48小时完成率分子")
    @TableField("forty_eight_finishrate_numerator")
    private Double fortyEightFinishrateNumerator;

    @ApiModelProperty(value = "48小时完成率分母")
    @TableField("forty_eight_finishrate_denominator")
    private Double fortyEightFinishrateDenominator;

    @ApiModelProperty(value = "完成率分子")
    @TableField("finish_rate_numerator")
    private Double finishRateNumerator;

    @ApiModelProperty(value = "完成率分母")
    @TableField("finish_rate_denominator")
    private Double finishRateDenominator;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("modify_time")
    private Date modifyTime;


}
