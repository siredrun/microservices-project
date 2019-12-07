package com.baijiaxiu.services.cloud.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @description: 报表查询条件
 * @author: liuyufeng
 * @date: 2019-08-28 16:21
 */
@Data
@ApiModel(value = "报表查询条件", description = "报表查询条件")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ReportQueryDTO {
    @ApiModelProperty(value = "城市id")
    private Integer cityId;

    @ApiModelProperty(value = "开始时间")
    private Integer startDate;

    @ApiModelProperty(value = "结束时间")
    private Integer endDate;

    @ApiModelProperty(value = "类型")
    @NotNull(message = "类型不能为空")
    private Integer type;



}
