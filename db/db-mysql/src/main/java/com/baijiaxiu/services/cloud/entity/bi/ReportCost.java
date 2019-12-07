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
 * 成本报表
 * </p>
 *
 * @author liuyufeng
 * @since 2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ReportCost对象", description = "成本报表")
public class ReportCost implements Serializable {

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

    @ApiModelProperty(value = "总单均分子")
    @TableField("total_average_numerator")
    private Double totalAverageNumerator;

    @ApiModelProperty(value = "总单均分母")
    @TableField("total_average_denominator")
    private Double totalAverageDenominator;

    @ApiModelProperty(value = "综合单均分子")
    @TableField("synthesize_average_numerator")
    private Double synthesizeAverageNumerator;

    @ApiModelProperty(value = "综合单均分母")
    @TableField("synthesize_average_denominator")
    private Double synthesizeAverageDenominator;

    @ApiModelProperty(value = "电器单均分子")
    @TableField("electrical_average_numerator")
    private Double electricalAverageNumerator;

    @ApiModelProperty(value = "电器单均分母")
    @TableField("electrical_average_denominator")
    private Double electricalAverageDenominator;

    @ApiModelProperty(value = "混合单均分子")
    @TableField("mixture_average_numerator")
    private Double mixtureAverageNumerator;

    @ApiModelProperty(value = "混合单均分母")
    @TableField("mixture_average_denominator")
    private Double mixtureAverageDenominator;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("modify_time")
    private Date modifyTime;


}
