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
 * 品质报表
 * </p>
 *
 * @author liuyufeng
 * @since 2019-09-02
 */
@Data
@ApiModel(value = "品质报表", description = "品质报表")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ReportQualityVO implements Serializable {

    @ApiModelProperty(value = "主键(日期)")
    @ExcelIgnore
    private String date;

    @ApiModelProperty(value = "城市名称")
    @ExcelProperty({"名称", "城市"})
    private String cityName;

    @ApiModelProperty(value = "城市id")
    @ExcelIgnore
    private Integer cityId;

    @ApiModelProperty(value = "当日完单量")
    @ExcelProperty({"当日品质", "当日完成单量"})
    private String dayCompleted;

    @ApiModelProperty(value = "当日评价单量")
    @ExcelProperty({"当日品质", "当日评价单量"})
    private String dayEvaluationQuantity;

    @ApiModelProperty(value = "当日评价率")
    @ExcelProperty({"当日品质", "当日评价率"})
    private String dayEvaluationRate;

    @ApiModelProperty(value = "当日5星好评率")
    @ExcelProperty({"当日品质", "当日5星好评率"})
    private String dayFiveStarRating;

    @ApiModelProperty(value = "当日满意率")
    @ExcelProperty({"当日品质", "当日满意率"})
    private String daySatisfactionRate;

    @ApiModelProperty(value = "累计完成单量")
    @ExcelProperty({"累计品质", "累计完成单量"})
    private String totalCompleted;

    @ApiModelProperty(value = "累计评价单量")
    @ExcelProperty({"累计品质", "累计评价单量"})
    private String totalEvaluationQuantity;

    @ApiModelProperty(value = "累计评价率")
    @ExcelProperty({"累计品质", "累计评价率"})
    private String totalEvaluationRate;

    @ApiModelProperty(value = "累计5星好评率")
    @ExcelProperty({"累计品质", "累计5星好评率"})
    private String totalFiveStarRating;

    @ApiModelProperty(value = "累计满意率")
    @ExcelProperty({"累计品质", "累计满意率"})
    private String totalSatisfactionRate;

    @ApiModelProperty(value = "创建时间")
    @ExcelIgnore
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @ExcelIgnore
    private Date modifyTime;


}
