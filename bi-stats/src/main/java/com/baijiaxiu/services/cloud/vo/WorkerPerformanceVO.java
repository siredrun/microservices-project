package com.baijiaxiu.services.cloud.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:
 * @author: chenxingxing
 * @date: 2019/11/11 11:56
 */
@Data
@ApiModel(value = "师傅绩效展示", description = "师傅绩效展示")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class WorkerPerformanceVO {

    @ApiModelProperty(value = "师傅Id")
    private Integer workerId;

    @ApiModelProperty(value = "师傅名字")
    private String workerName;

    @ApiModelProperty(value = "联系及时率")
    private String contactOntime;

    @ApiModelProperty(value = "完成率")
    private String finish;

    @ApiModelProperty(value = "综合单均成本")
    private String synthesizeAvgrage;

    @ApiModelProperty(value = "电器单均成本")
    private String electricalAvgrate;

    @ApiModelProperty(value = "综合电器单均成本")
    private String mixtureAvgrate;

    @ApiModelProperty(value = "90天重复维修率")
    private String ninetyRework;

    @ApiModelProperty(value = "紧急三小时上门率")
    private String visitOntimeExigency;

    @ApiModelProperty(value = "评价平均分")
    private String avgScore;

    @ApiModelProperty(value = "方案一次通过率")
    private String programPassrateOnetime;

    @ApiModelProperty(value = "普通上门及时率")
    private String visitOntime;

    @ApiModelProperty(value = "评价率")
    private String evaluate;

    @ApiModelProperty(value = "五星好评率")
    private String fiveStartEvaluate;

    @ApiModelProperty(value = "疑难量(维修费用超过500)")
    private String difficultOrderNum;

    @ApiModelProperty(value = "防水单均成本")
    private String waterproofAvgrate;
}
