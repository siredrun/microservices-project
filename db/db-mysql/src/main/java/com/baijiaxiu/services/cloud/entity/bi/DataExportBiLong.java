package com.baijiaxiu.services.cloud.entity.bi;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2019-10-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("data_export_BI_long")
@ApiModel(value="DataExportBiLong对象", description="")
public class DataExportBiLong implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "工单ID")
    @TableId("out_order_no")
    private String outOrderNo;

    @ApiModelProperty(value = "首次维修方案通过备注")
    @TableField("pass_remark_first_plan")
    private String passRemarkFirstPlan;

    @ApiModelProperty(value = "最后通过协调维修方案")
    @TableField("pass_finall_coorcoordinatedplan")
    private String passFinallCoorcoordinatedplan;

    @ApiModelProperty(value = "结算审核信息")
    @TableField("account_info")
    private String accountInfo;


}
