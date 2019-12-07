package com.baijiaxiu.services.cloud.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 工单类型报表
 * </p>
 *
 * @author liuyufeng
 * @since 2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "工单类型报表", description = "工单类型报表")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ReportOrderTypeVO implements Serializable {

    @ApiModelProperty(value = "主键(日期)")
    @ExcelIgnore
    private String date;

    @ApiModelProperty(value = "城市名称")
    @ExcelProperty({"名称", "城市"})
    private String cityName;

    @ApiModelProperty(value = "城市id")
    @ExcelIgnore
    private Integer cityId;

    @ApiModelProperty(value = "单量")
    @ExcelProperty({"名称", "单量"})
    private String orderNum;

    @ApiModelProperty(value = "综合单量")
    @ExcelProperty({"当日工单类型", "综合单量"})
    private String synthesizeNum;

    @ApiModelProperty(value = "完成的综合单量")
    @ExcelProperty({"当日工单类型", "综合完成"})
    private String synthesizeFinishNum;

    @ApiModelProperty(value = "电器单量")
    @ExcelProperty({"当日工单类型", "电器单量"})
    private String electricNum;

    @ApiModelProperty(value = "完成的电器单量")
    @ExcelProperty({"当日工单类型", "电器完成"})
    private String electricFinishNum;

    @ApiModelProperty(value = "综合电器单量")
    @ExcelProperty({"当日工单类型", "电器综合单量"})
    private String synElectricNum;

    @ApiModelProperty(value = "完成的综合电器单量")
    @ExcelProperty({"当日工单类型", "电器综合完成"})
    private String synElectricFinishNum;

    @ApiModelProperty(value = "防水单量")
    @ExcelProperty({"当日工单类型", "防水单量"})
    private String waterproofNum;

    @ApiModelProperty(value = "完成的防水单量")
    @ExcelProperty({"当日工单类型", "防水完成"})
    private String waterproofFinishNum;

    @ApiModelProperty(value = "报修单量")
    @ExcelProperty({"当日工单标签", "报修单量"})
    private String repairNum;

    @ApiModelProperty(value = "返工单量")
    @ExcelProperty({"当日工单标签", "返工单量"})
    private String reworkNum;

    @ApiModelProperty(value = "巡房单量")
    @ExcelProperty({"当日工单标签", "巡房单量"})
    private String roundHouseNum;

    @ApiModelProperty(value = "退租单量")
    @ExcelProperty({"当日工单标签", "退租单量"})
    private String surrenderNum;

    @ApiModelProperty(value = "巡检单量")
    @ExcelProperty({"当日工单标签", "巡检单量"})
    private String pollingNum;

    @ApiModelProperty(value = "撤销单量")
    @ExcelProperty({"当日工单标签", "撤销单量"})
    private String backoutNum;

    @ApiModelProperty(value = "当月累计单量")
    @ExcelProperty({"累计工单类型", "单量"})
    private String monthOrderNum;

    @ApiModelProperty(value = "当月累计综合单量")
    @ExcelProperty({"累计工单类型", "综合单量"})
    private String monthSynthesizeNum;

    @ApiModelProperty(value = "当月累计完成综合单量")
    @ExcelProperty({"累计工单类型", "综合完成"})
    private String monthSynthesizeFinishNum;

    @ApiModelProperty(value = "当月累计电器单量")
    @ExcelProperty({"累计工单类型", "电器单量"})
    private String monthElectricNum;

    @ApiModelProperty(value = "当月累计完成电器单量")
    @ExcelProperty({"累计工单类型", "电器完成"})
    private String monthElectricFinishNum;

    @ApiModelProperty(value = "当月累计综合电器单量")
    @ExcelProperty({"累计工单类型", "电器综合单量"})
    private String monthSynElectricNum;

    @ApiModelProperty(value = "当月综合累计完成电器单量")
    @ExcelProperty({"累计工单类型", "电器综合完成"})
    private String monthSynElectricFinishNum;

    @ApiModelProperty(value = "当月累计防水单量")
    @ExcelProperty({"累计工单类型", "防水单量"})
    private String monthWaterproofNum;

    @ApiModelProperty(value = "当月累计完成防水单量")
    @ExcelProperty({"累计工单类型", "防水完成"})
    private String monthWaterproofFinishNum;

    @ApiModelProperty(value = "当月累计报修单量")
    @ExcelProperty({"累计工单标签", "报修单量"})
    private String monthRepairNum;

    @ApiModelProperty(value = "当月累计返工单量")
    @ExcelProperty({"累计工单标签", "返工单量"})
    private String monthReworkNum;

    @ApiModelProperty(value = "当月累计巡房单量")
    @ExcelProperty({"累计工单标签", "巡房单量"})
    private String monthRoundHouseNum;

    @ApiModelProperty(value = "当月累计退租单量")
    @ExcelProperty({"累计工单标签", "退租单量"})
    private String monthSurrenderNum;

    @ApiModelProperty(value = "当月累计巡检单量")
    @ExcelProperty({"累计工单标签", "巡检单量"})
    private String monthPollingNum;

    @ApiModelProperty(value = "当月累计撤销单量")
    @ExcelProperty({"累计工单标签", "撤销单量"})
    private String monthBackoutNum;

    @ApiModelProperty(value = "创建时间")
    @ExcelIgnore
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @ExcelIgnore
    private Date modifyTime;


}
