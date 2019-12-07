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
 * 品质报表
 * </p>
 *
 * @author liuyufeng
 * @since 2019-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ReportQuality对象", description = "品质报表")
public class ReportQuality implements Serializable {

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

    @ApiModelProperty(value = "当日完单量")
    @TableField("day_completed")
    private Double dayCompleted;

    @ApiModelProperty(value = "当日评价单量")
    @TableField("day_evaluation_quantity")
    private Double dayEvaluationQuantity;

    @ApiModelProperty(value = "当日评价率分子")
    @TableField("day_evaluation_rate_numerator")
    private Double dayEvaluationRateNumerator;

    @ApiModelProperty(value = "当日评价率分母")
    @TableField("day_evaluation_rate_denominator")
    private Double dayEvaluationRateDenominator;

    @ApiModelProperty(value = "当日5星好评率分子")
    @TableField("day_five_star_rating_numerator")
    private Double dayFiveStarRatingNumerator;

    @ApiModelProperty(value = "当日5星好评率分母")
    @TableField("day_five_star_rating_denominator")
    private Double dayFiveStarRatingDenominator;

    @ApiModelProperty(value = "当日满意率分子")
    @TableField("day_satisfaction_rate_numerator")
    private Double daySatisfactionRateNumerator;

    @ApiModelProperty(value = "当日满意率分母")
    @TableField("day_satisfaction_rate_denominator")
    private Double daySatisfactionRateDenominator;

    @ApiModelProperty(value = "累计完成单量")
    @TableField("total_completed")
    private Double totalCompleted;

    @ApiModelProperty(value = "累计评价单量")
    @TableField("total_evaluation_quantity")
    private Double totalEvaluationQuantity;

    @ApiModelProperty(value = "累计5星好评分子")
    @TableField("total_five_star_rating_numerator")
    private Double totalFiveStarRatingNumerator;

    @ApiModelProperty(value = "累计5星好评分母")
    @TableField("total_five_star_rating_denominator")
    private Double totalFiveStarRatingDenominator;

    @ApiModelProperty(value = "累计满意分子")
    @TableField("total_satisfaction_rate_numerator")
    private Double totalSatisfactionRateNumerator;

    @ApiModelProperty(value = "累计满意分母")
    @TableField("total_satisfaction_rate_denominator")
    private Double totalSatisfactionRateDenominator;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("modify_time")
    private Date modifyTime;


}
