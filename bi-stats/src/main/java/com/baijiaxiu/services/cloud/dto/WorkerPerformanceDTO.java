package com.baijiaxiu.services.cloud.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:
 * @author: chenxingxing
 * @date: 2019/11/11 11:39
 */
@Data
@ApiModel(value = "师傅绩效查询条件", description = "师傅绩效查询条件")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class WorkerPerformanceDTO {

    /**
     * 师傅Id
     */
    @ApiModelProperty(value = "师傅Id")
    private Integer workerId;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    private String startDate;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    private String endDate;

    /**
     * 验签
     */
    @ApiModelProperty(value = "验签")
    private String sign;
}