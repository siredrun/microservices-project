package com.baijiaxiu.services.cloud.entity.bi;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 工单结算表
 * </p>
 *
 * @author liuyufeng
 * @since 2019-08-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "OrderAccount对象", description = "工单结算表")
public class OrderAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "工单id")
    @TableField("order_id")
    private Long orderId;

    @ApiModelProperty(value = "维修方案id")
    @TableField("maintain_plan_id")
    private Long maintainPlanId;

    @ApiModelProperty(value = "上门费用")
    @TableField("call_money")
    private BigDecimal callMoney;

    @ApiModelProperty(value = "责任鉴定(1-租户责任，2-非租户责任)")
    @TableField("duty_identify")
    private Integer dutyIdentify;

    @ApiModelProperty(value = "加急费用")
    @TableField("urgent_money")
    private BigDecimal urgentMoney;

    @ApiModelProperty(value = "其他费用")
    @TableField("other_money")
    private BigDecimal otherMoney;

    @ApiModelProperty(value = "维修配件")
    @TableField("maintain_parts")
    private String maintainParts;

    @ApiModelProperty(value = "结算状态(1、通过；2、不通过；3、待审核)")
    @TableField("account_status")
    private Integer accountStatus;

    @ApiModelProperty(value = "配件费用总计")
    @TableField("parts_total_cost")
    private BigDecimal partsTotalCost;

    @ApiModelProperty(value = "结算方案总费用")
    @TableField("total_cost")
    private BigDecimal totalCost;

    @ApiModelProperty(value = "是否为保外维修单(1-是；2-否)")
    @TableField("is_released")
    private Integer isReleased;

    @ApiModelProperty(value = "审核人")
    @TableField("check_user")
    private String checkUser;

    @ApiModelProperty(value = "审核时间")
    @TableField("check_time")
    private Date checkTime;

    @ApiModelProperty(value = "审批备注")
    @TableField("check_remark")
    private String checkRemark;

    @ApiModelProperty(value = "审核升级(1-是，2-否)")
    @TableField("check_upgrade")
    private Integer checkUpgrade;

    @ApiModelProperty(value = "备注说明")
    @TableField("remark")
    private String remark;

    @ApiModelProperty(value = "创建人")
    @TableField("create_user")
    private String createUser;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改人")
    @TableField("modify_user")
    private String modifyUser;

    @ApiModelProperty(value = "修改时间")
    @TableField("modify_time")
    private Date modifyTime;


}
