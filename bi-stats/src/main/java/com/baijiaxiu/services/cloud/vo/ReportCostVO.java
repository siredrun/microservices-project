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
 * 成本报表
 * </p>
 *
 * @author liuyufeng
 * @since 2019-09-03
 */
@Data
@ApiModel(value = "成本报表", description = "成本报表")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ReportCostVO implements Serializable {

    @ApiModelProperty(value = "主键(日期)")
    @ExcelIgnore
    private String date;

    @ApiModelProperty(value = "城市名称")
    @ExcelProperty("城市")
    private String cityName;

    @ApiModelProperty(value = "城市id")
    @ExcelIgnore
    private Integer cityId;

    @ApiModelProperty(value = "总单均")
    @ExcelProperty("总单均")
    private String totalAverage;

    @ApiModelProperty(value = "综合单均")
    @ExcelProperty("综合单均")
    private String synthesizeAverage;

    @ApiModelProperty(value = "电器单均")
    @ExcelProperty("电器单均")
    private String electricalAverage;

    @ApiModelProperty(value = "混合单均")
    @ExcelProperty("综合电器单均")
    private String mixtureAverage;

    @ApiModelProperty(value = "创建时间")
    @ExcelIgnore
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @ExcelIgnore
    private Date modifyTime;
}
