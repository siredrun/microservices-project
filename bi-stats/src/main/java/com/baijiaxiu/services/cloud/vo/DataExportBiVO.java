package com.baijiaxiu.services.cloud.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author liuyufeng
 * @since 2019-10-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("data_export_BI")
@ApiModel(value = "订单导出数据字段描述", description = "")
public class DataExportBiVO implements Serializable {

    @ExcelIgnore
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "来源")
    @ExcelProperty("来源")
    private String createSource;

    @ApiModelProperty(value = "供应类型")
    @ExcelProperty("供应类型")
    private String supplierType;

    @ApiModelProperty(value = "城市")
    @ExcelProperty("城市")
    private String city;

    @ApiModelProperty(value = "工单ID")
    @TableId("out_order_no")
    @ExcelProperty("工单ID")
    private String outOrderNo;

    @ApiModelProperty(value = "公寓号")
    @ExcelProperty("公寓号")
    private String houseId;

    @ApiModelProperty(value = "行政区")
    @ExcelProperty("行政区")
    private String district;

    @ApiModelProperty(value = "商圈")
    @ExcelProperty("商圈")
    private String tradingArea;

    @ApiModelProperty(value = "小区名称")
    @ExcelProperty("小区名称")
    private String blockName;

    @ApiModelProperty(value = "详细地址")
    @ExcelProperty("详细地址")
    private String detailAddress;

    @ApiModelProperty(value = "报修区域")
    @ExcelProperty("报修区域")
    private String initiateRepairArea;

    @ApiModelProperty(value = "租户报修描述")
    @ExcelProperty("租户报修描述")
    private String faultDescriptionUser;

    @ApiModelProperty(value = "工单紧急标签")
    @ExcelProperty("工单紧急标签")
    private String exigencyFlag;

    @ApiModelProperty(value = "工单标签")
    @ExcelProperty("工单标签")
    private String orderFlag;

    @ApiModelProperty(value = "工单状态")
    @ExcelProperty("工单状态")
    private String orderStatus;

    @ApiModelProperty(value = "创建人")
    @ExcelProperty("创建人")
    private String createUser;

    @ApiModelProperty(value = "工单报修人姓名")
    @ExcelProperty("工单报修人姓名")
    private String initiateRepairName;

    @ApiModelProperty(value = "工单报修人电话")
    @ExcelProperty("工单报修人电话")
    private String initiateRepairTel;

    @ApiModelProperty(value = "维修师傅姓名")
    @ExcelProperty("维修师傅姓名")
    private String workerName;

    @ApiModelProperty(value = "维修师傅技能")
    @ExcelProperty("维修师傅技能")
    private String skillKind;

    @ApiModelProperty(value = "维修师傅电话")
    @ExcelProperty("维修师傅电话")
    private String workerTel;

    @ApiModelProperty(value = "维修师傅状态")
    @ExcelProperty("维修师傅状态")
    private String isInservice;

    @ApiModelProperty(value = "蛋壳客服认领时间")
    @ExcelProperty("蛋壳客服认领时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private Date claimTime;

    @ApiModelProperty(value = "订单客服认领人")
    @ExcelProperty("订单客服认领人")
    private String claimer;

    @ApiModelProperty(value = "订单创建时间")
    @ExcelProperty("订单创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "转派供应商时间")
    @ExcelProperty("转派供应商时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private Date allocationTime;

    @ApiModelProperty(value = "维修员联系时间")
    @ExcelProperty("维修员联系时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private Date workerContactTime;

    @ApiModelProperty(value = "维修员上门签到时间")
    @ExcelProperty("维修员上门签到时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private Date visitSignTime;

    @ApiModelProperty(value = "当前预约日期")
    @ExcelProperty("当前预约日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private Date changeDay;

    @ApiModelProperty(value = "当前预约时间")
    @ExcelProperty("当前预约时间")
    private String changeTimes;

    @ApiModelProperty(value = "首次转派时间")
    @ExcelProperty("首次转派时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private Date transferTime;

    @ApiModelProperty(value = "退单时间")
    @ExcelProperty("退单时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private Date sendbackTime;

    @ApiModelProperty(value = "百家修受理时间")
    @ExcelProperty("百家修受理时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private Date createTimeBjx;

    @ApiModelProperty(value = "分派维修员时间")
    @ExcelProperty("分派维修员时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private Date reppairmanTime;

    @ApiModelProperty(value = "评价满意度")
    @ExcelProperty("评价满意度")
    private String evaluationStatisfaction;

    @ApiModelProperty(value = "评价均分")
    @ExcelProperty("评价均分")
    private String avgScore;

    @ApiModelProperty(value = "服务礼仪")
    @ExcelProperty("服务礼仪")
    private String serviceEtiquette;

    @ApiModelProperty(value = "服务态度")
    @ExcelProperty("服务态度")
    private String serviceAttitude;

    @ApiModelProperty(value = "上门时效")
    @ExcelProperty("上门时效")
    private String visitEfficiency;

    @ApiModelProperty(value = "维修结果")
    @ExcelProperty("维修结果")
    private String repairResult;

    @ApiModelProperty(value = "整体服务")
    @ExcelProperty("整体服务")
    private String serviceInteg;

    @ApiModelProperty(value = "评价备注")
    @ExcelProperty("评价备注")
    private String clientRemark;

    @ApiModelProperty(value = "评价时间")
    @ExcelProperty("评价时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private Date evaluateTime;

    @ApiModelProperty(value = "改期次数")
    @ExcelProperty("改期次数")
    private String countChange;

    @ApiModelProperty(value = "完成时间")
    @ExcelProperty("完成时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private Date practicalFinishTime;

    @ApiModelProperty(value = "一级分类")
    @ExcelProperty("一级分类")
    private String firstGradeName;

    @ApiModelProperty(value = "二级分类")
    @ExcelProperty("二级分类")
    private String secondGradeName;

    @ApiModelProperty(value = "三级分类")
    @ExcelProperty("三级分类")
    private String thirdGradeName;

    @ApiModelProperty(value = "首次维修方案创建时间")
    @ExcelProperty("首次维修方案创建时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private Date createTimeFirstPlan;

    @ApiModelProperty(value = "首次维修方案审核结果")
    @ExcelProperty("首次维修方案审核结果")
    private String checkResultFirstPlan;

    @ApiModelProperty(value = "是否协调单")
    @ExcelProperty("是否协调单")
    private String ifCoordinated;

    @ApiModelProperty(value = "首次维修方案通过时间")
    @ExcelProperty("首次维修方案通过时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private Date psstimeFirstPlan;

    @ApiModelProperty(value = "首次维修方案通过备注")
    @ExcelProperty("首次维修方案通过备注")
    private String passRemarkFirstPlan;

    @ApiModelProperty(value = "协调反馈通过次数")
    @ExcelProperty("协调反馈通过次数")
    private String coordinatedFeedbackPasscount;

    @ApiModelProperty(value = "最后通过协调维修方案审核时间")
    @ExcelProperty("最后通过协调维修方案审核时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private Date passtimeFinallCoorcoordinatedplan;

    @ApiModelProperty(value = "最后通过协调维修方案审核人")
    @ExcelProperty("最后通过协调维修方案审核人")
    private String finallCoorcoordinatedplanCheckuser;

    @ApiModelProperty(value = "最后通过协调维修方案")
    @ExcelProperty("最后通过协调维修方案")
    private String passFinallCoorcoordinatedplan;

    @ApiModelProperty(value = "结算审核信息")
    @ExcelProperty("结算审核信息")
    private String accountInfo;

    @ApiModelProperty(value = "上门费")
    @ExcelProperty("上门费")
    private String visitAmount;

    @ApiModelProperty(value = "配件费")
    @ExcelProperty("配件费")
    private String partsAmount;

    @ApiModelProperty(value = "加急费")
    @ExcelProperty("加急费")
    private String urgentAmount;

    @ApiModelProperty(value = "其他费")
    @ExcelProperty("其他费")
    private String otherAmount;

    @ApiModelProperty(value = "责任鉴定")
    @ExcelProperty("责任鉴定")
    private String dutyIdentify;

    @ApiModelProperty(value = "维修方案结算审核状态")
    @ExcelProperty("维修方案结算审核状态")
    private String accountStatus;

    @ApiModelProperty(value = "结算审核人")
    @ExcelProperty("结算审核人")
    private String accountCheckUser;

    @ApiModelProperty(value = "结算审核通过时间")
    @ExcelProperty("结算审核通过时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private Date passtimeAccountCheck;

    @ApiModelProperty(value = "客服报修描述")
    @ExcelProperty("客服报修描述")
    private String faultDescriptionCuse;

    @ApiModelProperty(value = "是否保外维修单")
    @ExcelProperty("是否保外维修单")
    private String isReleased;

    @ApiModelProperty(value = "自定义配件信息")
    @ExcelProperty("自定义配件信息")
    private String partsInfo;

    @ApiModelProperty(value = "统计更新时间")
    @ExcelIgnore
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private Date computeTime;


}
