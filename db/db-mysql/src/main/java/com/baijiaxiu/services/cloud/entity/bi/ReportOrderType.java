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
 * 工单类型报表
 * </p>
 *
 * @author liuyufeng
 * @since 2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ReportOrderType对象", description = "工单类型报表")
public class ReportOrderType implements Serializable {

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

    @ApiModelProperty(value = "单量")
    @TableField("order_num")
    private Double orderNum;

    @ApiModelProperty(value = "综合单量")
    @TableField("synthesize_num")
    private Double synthesizeNum;

    @ApiModelProperty(value = "完成的综合单量")
    @TableField("synthesize_finish_num")
    private Double synthesizeFinishNum;

    @ApiModelProperty(value = "电器单量")
    @TableField("electric_num")
    private Double electricNum;

    @ApiModelProperty(value = "完成的电器单量")
    @TableField("electric_finish_num")
    private Double electricFinishNum;

    @ApiModelProperty(value = "综合电器单量")
    @TableField("syn_electric_num")
    private Double synElectricNum;

    @ApiModelProperty(value = "完成的综合电器单量")
    @TableField("syn_electric_finish_num")
    private Double synElectricFinishNum;

    @ApiModelProperty(value = "防水单量")
    @TableField("waterproof_num")
    private Double waterproofNum;

    @ApiModelProperty(value = "完成的防水单量")
    @TableField("waterproof_finish_num")
    private Double waterproofFinishNum;

    @ApiModelProperty(value = "报修单量")
    @TableField("repair_num")
    private Double repairNum;

    @ApiModelProperty(value = "返工单量")
    @TableField("rework_num")
    private Double reworkNum;

    @ApiModelProperty(value = "巡房单量")
    @TableField("round_house_num")
    private Double roundHouseNum;

    @ApiModelProperty(value = "退租单量")
    @TableField("surrender_num")
    private Double surrenderNum;

    @ApiModelProperty(value = "巡检单量")
    @TableField("polling_num")
    private Double pollingNum;

    @ApiModelProperty(value = "撤销单量")
    @TableField("backout_num")
    private Double backoutNum;

    @ApiModelProperty(value = "当月累计单量")
    @TableField("month_order_num")
    private Double monthOrderNum;

    @ApiModelProperty(value = "当月累计综合单量")
    @TableField("month_synthesize_num")
    private Double monthSynthesizeNum;

    @ApiModelProperty(value = "当月累计完成综合单量")
    @TableField("month_synthesize_finish_num")
    private Double monthSynthesizeFinishNum;

    @ApiModelProperty(value = "当月累计电器单量")
    @TableField("month_electric_num")
    private Double monthElectricNum;

    @ApiModelProperty(value = "当月累计完成电器单量")
    @TableField("month_electric_finish_num")
    private Double monthElectricFinishNum;

    @ApiModelProperty(value = "当月累计综合电器单量")
    @TableField("month_syn_electric_num")
    private Double monthSynElectricNum;

    @ApiModelProperty(value = "当月综合累计完成电器单量")
    @TableField("month_syn_electric_finish_num")
    private Double monthSynElectricFinishNum;

    @ApiModelProperty(value = "当月累计防水单量")
    @TableField("month_waterproof_num")
    private Double monthWaterproofNum;

    @ApiModelProperty(value = "当月累计完成防水单量")
    @TableField("month_waterproof_finish_num")
    private Double monthWaterproofFinishNum;

    @ApiModelProperty(value = "当月累计报修单量")
    @TableField("month_repair_num")
    private Double monthRepairNum;

    @ApiModelProperty(value = "当月累计返工单量")
    @TableField("month_rework_num")
    private Double monthReworkNum;

    @ApiModelProperty(value = "当月累计巡房单量")
    @TableField("month_round_house_num")
    private Double monthRoundHouseNum;

    @ApiModelProperty(value = "当月累计退租单量")
    @TableField("month_surrender_num")
    private Double monthSurrenderNum;

    @ApiModelProperty(value = "当月累计巡检单量")
    @TableField("month_polling_num")
    private Double monthPollingNum;

    @ApiModelProperty(value = "当月累计撤销单量")
    @TableField("month_backout_num")
    private Double monthBackoutNum;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("modify_time")
    private Date modifyTime;


}
