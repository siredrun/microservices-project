package com.baijiaxiu.services.cloud.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 订单导出
 * @author: liuyufeng
 * @date: 2019-08-28 16:21
 */
@Data
@ApiModel(value = "订单导出查询条件", description = "订单导出查询条件")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DataQueryDTO {

    /**
     * 城市名称
     */
    @ApiModelProperty(value = "城市名称")
    private String cityName;

    /**
     * 师傅Id
     */
    @ApiModelProperty(value = "师傅Id")
    private String workerId;

    /**
     * 创建开始时间 格式yyyy-MM-dd HH:mm:ss
     */
    @ApiModelProperty(value = "创建开始时间 格式yyyy-MM-dd HH:mm:ss")
    private String createStartDate;

    /**
     * 创建结束时间 格式yyyy-MM-dd HH:mm:ss
     */
    @ApiModelProperty(value = "创建结束时间 格式yyyy-MM-dd HH:mm:ss")
    private String createEndDate;

    /**
     * 转派开始时间 格式yyyy-MM-dd HH:mm:ss
     */
    @ApiModelProperty(value = "转派开始时间 格式yyyy-MM-dd HH:mm:ss")
    private String allocationStartTime;

    /**
     * 转派结束时间 格式yyyy-MM-dd HH:mm:ss
     */
    @ApiModelProperty(value = "转派结束时间 格式yyyy-MM-dd HH:mm:ss")
    private String allocationEndTime;

    /**
     * 完成开始时间 格式yyyy-MM-dd HH:mm:ss
     */
    @ApiModelProperty(value = "转派开始时间 格式yyyy-MM-dd HH:mm:ss")
    private String finishStartTime;

    /**
     * 完成转派结束时间 格式yyyy-MM-dd HH:mm:ss
     */
    @ApiModelProperty(value = "转派结束时间 格式yyyy-MM-dd HH:mm:ss")
    private String finishEndTime;
}
