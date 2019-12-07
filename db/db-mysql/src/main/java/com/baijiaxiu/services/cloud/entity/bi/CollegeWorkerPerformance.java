package com.baijiaxiu.services.cloud.entity.bi;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author liuyufeng
 * @since 2019-11-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CollegeWorkerPerformance对象", description="")
public class CollegeWorkerPerformance implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "日期")
    @TableId("date")
    private String date;

    @ApiModelProperty(value = "城市名称")
    @TableField("city_name")
    private String cityName;

    @ApiModelProperty(value = "师傅ID")
    @TableField("worker_id")
    private Integer workerId;

    @ApiModelProperty(value = "师傅姓名")
    @TableField("worker_name")
    private String workerName;

    @ApiModelProperty(value = "城市ID")
    @TableField("city")
    private String city;

    @ApiModelProperty(value = "1小时联系及时率分子")
    @TableField("contact_ontime_numerator")
    private Double contactOntimeNumerator;

    @ApiModelProperty(value = "1小时联系及时率分母")
    @TableField("contact_ontime_denominator")
    private Double contactOntimeDenominator;

    @ApiModelProperty(value = "紧急3小时上门率分子")
    @TableField("visit_ontime_exigency_numerator")
    private Double visitOntimeExigencyNumerator;

    @ApiModelProperty(value = "紧急3小时上门率分母")
    @TableField("visit_ontime_exigency_denominator")
    private Double visitOntimeExigencyDenominator;

    @ApiModelProperty(value = "普通上门及时率分子")
    @TableField("visit_ontime_numerator")
    private Double visitOntimeNumerator;

    @ApiModelProperty(value = "普通上门及时率分母")
    @TableField("visit_ontime_denominator")
    private Double visitOntimeDenominator;

    @ApiModelProperty(value = "48小时完成率分子")
    @TableField("finish_numerator")
    private Double finishNumerator;

    @ApiModelProperty(value = "48小时完成率分母")
    @TableField("finish_denominator")
    private Double finishDenominator;

    @ApiModelProperty(value = "评价平均分分子")
    @TableField("avg_score_numerator")
    private Double avgScoreNumerator;

    @ApiModelProperty(value = "评价平均分分母")
    @TableField("avg_score_denominator")
    private Double avgScoreDenominator;

    @ApiModelProperty(value = "评价率分子")
    @TableField("evaluate_numerator")
    private Double evaluateNumerator;

    @ApiModelProperty(value = "评价率分母")
    @TableField("evaluate_denominator")
    private Double evaluateDenominator;

    @ApiModelProperty(value = "五星好评率分子")
    @TableField("five_start_evaluate_numerator")
    private Double fiveStartEvaluateNumerator;

    @ApiModelProperty(value = "五星好评率分母")
    @TableField("five_start_evaluate_denominator")
    private Double fiveStartEvaluateDenominator;

    @ApiModelProperty(value = "维修方案一次通过率分子")
    @TableField("program_passrate_onetime_numerator")
    private Double programPassrateOnetimeNumerator;

    @ApiModelProperty(value = "维修方案一次通过率分母")
    @TableField("program_passrate_onetime_denominator")
    private Double programPassrateOnetimeDenominator;

    @ApiModelProperty(value = "90天重复维修率分子")
    @TableField("ninety_rework_numerator")
    private Double ninetyReworkNumerator;

    @ApiModelProperty(value = "90天重复维修率分母")
    @TableField("ninety_rework_denominator")
    private Double ninetyReworkDenominator;

    @ApiModelProperty(value = "综合单均分子")
    @TableField("synthesize_avgrage_numerator")
    private Double synthesizeAvgrageNumerator;

    @ApiModelProperty(value = "综合单均分母")
    @TableField("synthesize_avgrage_denominator")
    private Double synthesizeAvgrageDenominator;

    @ApiModelProperty(value = "电器单均分子")
    @TableField("electrical__avgrate_numerator")
    private Double electricalAvgrateNumerator;

    @ApiModelProperty(value = "电器单均分母")
    @TableField("electrical_avgrate_denominator")
    private Double electricalAvgrateDenominator;

    @ApiModelProperty(value = "综合电器单均分子")
    @TableField("mixture_avgrate_numerator")
    private Double mixtureAvgrateNumerator;

    @ApiModelProperty(value = "综合电器单均分母")
    @TableField("mixture_avgrate_denominator")
    private Double mixtureAvgrateDenominator;

    @ApiModelProperty(value = "防水单均分子")
    @TableField("waterproof_avgrate_numerator")
    private Double waterproofAvgrateNumerator;

    @ApiModelProperty(value = "防水单均分母")
    @TableField("waterproof_avgrate_denominator")
    private Double waterproofAvgrateDenominator;

    @ApiModelProperty(value = "疑难单量")
    @TableField("difficult_order_num")
    private Double difficultOrderNum;

    @ApiModelProperty(value = "计算时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("modify_time")
    private Date modifyTime;


}
