package com.baijiaxiu.services.cloud.service.impl;

import com.baijiaxiu.services.cloud.common.utils.DateUtils;
import com.baijiaxiu.services.cloud.common.utils.NumberUtils;
import com.baijiaxiu.services.cloud.db.mapper.bi.ReportScaleMapper;
import com.baijiaxiu.services.cloud.entity.bi.ReportScale;
import com.baijiaxiu.services.cloud.service.IReportKpiService;
import com.baijiaxiu.services.cloud.service.IReportScaleService;
import com.baijiaxiu.services.cloud.vo.ReportScaleVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 规模报表 服务实现类
 * </p>
 *
 * @author liuyufeng
 * @since 2019-09-02
 */
@Service
public class ReportScaleServiceImpl extends ServiceImpl<ReportScaleMapper, ReportScale> implements IReportScaleService {

    @Autowired
    private IReportKpiService iReportKpiService;

    @Override
    public List<ReportScaleVO> listScales(Integer cityId, Integer startDate, Integer endDate) {
        String zeroStr = "0%";
        Double zero = 0.0;
        List<ReportScaleVO> scaleVOS = new ArrayList<>();
        List<ReportScale> list = listScale(cityId, startDate, endDate);
        if (list != null) {
            // 根据城市分组
            Map<Integer, List<ReportScale>> collect = list.stream().collect(Collectors.groupingBy(ReportScale::getCityId));
            for (Map.Entry<Integer, List<ReportScale>> listEntry : collect.entrySet()) {
                ReportScaleVO scaleVO = new ReportScaleVO();
                List<ReportScale> cityScale = listEntry.getValue();
                // 创建单量
                Double collect1 = cityScale.stream().mapToDouble(ReportScale::getCreateOrderQuantity).sum();
                scaleVO.setCreateOrderQuantity(String.valueOf(collect1.intValue()));
                // 紧急占比
                Double collect2 = cityScale.stream().mapToDouble(ReportScale::getEmergencyRatioNumerator).sum();
                Double collect3 = cityScale.stream().mapToDouble(ReportScale::getEmergencyRatioDenominator).sum();
                Double emergencyRatio = collect2 / collect3;
                if (collect3.equals(zero)) {
                    scaleVO.setEmergencyRatio(zeroStr);
                } else {
                    scaleVO.setEmergencyRatio(NumberUtils.formatDouble(emergencyRatio));
                }
                // 报修单量
                Double collect4 = cityScale.stream().mapToDouble(ReportScale::getRepairAmount).sum();
                scaleVO.setRepairAmount(String.valueOf(collect4.intValue()));
                // 完成单量
                Double collect5 = cityScale.stream().mapToDouble(ReportScale::getCompleteSingleQuantity).sum();
                scaleVO.setCompleteSingleQuantity(String.valueOf(collect5.intValue()));
                // 结算单量
                Double collect6 = cityScale.stream().mapToDouble(ReportScale::getBillingAmount).sum();
                scaleVO.setBillingAmount(String.valueOf(collect6.intValue()));
                // 结算积压单量
                Double collect7 = cityScale.stream().mapToDouble(ReportScale::getSettlementBacklogAmount).sum();
                scaleVO.setSettlementBacklogAmount(String.valueOf(collect7.intValue()));
                // 师傅人数
                Double collect8 = cityScale.get(cityScale.size() - 1).getNumberMasters();
                scaleVO.setNumberMasters(String.valueOf(collect8.intValue()));
                // 接单人数
//                Double collect9 = cityScale.stream().mapToDouble(ReportScale::getNumberOrders).sum();
                String startDateStr = DateUtils.strToDateFormat(startDate.toString(), DateUtils.DATE_SIMPLE_PATTERN, DateUtils.DATE_PATTERN);
                String endDateStr = DateUtils.strToDateFormat(endDate.toString(), DateUtils.DATE_SIMPLE_PATTERN, DateUtils.DATE_PATTERN);
                Double collect9 = iReportKpiService.getHumanEffectRateDenominator(cityScale.get(0).getCityId(), startDateStr, endDateStr);
                scaleVO.setNumberOrders(String.valueOf(collect9.intValue()));
                // 接单人效
                Double collect10 = cityScale.stream().mapToDouble(ReportScale::getOrderEffectNumerator).sum();
//                Double collect11 = cityScale.stream().mapToDouble(ReportScale::getOrderEffectDenominator).sum();
                Double orderEffect = collect10 / collect9;
                if (collect9.equals(zero)) {
                    scaleVO.setOrderEffect(zero.toString());
                } else {
                    scaleVO.setOrderEffect(NumberUtils.formatDouble(orderEffect, 2));
                }
                // 完成人效
                Double collect12 = cityScale.stream().mapToDouble(ReportScale::getCompleteHumanEffectNumerator).sum();
//                Double collect13 = cityScale.stream().mapToDouble(ReportScale::getCompleteHumanEffectDenominator).sum();
                Double completeHumanEffect = collect12 / collect9;
                if (collect9.equals(zero)) {
                    scaleVO.setCompleteHumanEffect(zero.toString());
                } else {
                    scaleVO.setCompleteHumanEffect(NumberUtils.formatDouble(completeHumanEffect, 2));
                }
                // 48小时遗留单量
                Double collect14 = cityScale.stream().mapToDouble(ReportScale::getFortyEightHourLegacyAmount).sum();
                scaleVO.setFortyEightHourLegacyAmount(String.valueOf(collect14.intValue()));
                scaleVO.setCityId(cityScale.get(0).getCityId());
                scaleVO.setCityName(cityScale.get(0).getCityName());
                // 计算环比
                String[] ringRatioTime = DateUtils.linkRelativeDate(startDate.toString(), endDate.toString(), DateUtils.DATE_SIMPLE_PATTERN);
                List<ReportScale> reportScales = listScale(cityScale.get(0).getCityId(), Integer.valueOf(ringRatioTime[0]), Integer.valueOf(ringRatioTime[1]));
                if (reportScales != null && reportScales.size() > 0) {
                    // 单量环比
                    Double lastCreateOrder = reportScales.stream().mapToDouble(ReportScale::getCreateOrderQuantity).sum();
                    if (lastCreateOrder.equals(zero)) {
                        scaleVO.setQuantityRingRatio("-");
                    } else {
                        scaleVO.setQuantityRingRatio(NumberUtils.formatDouble(collect1 / lastCreateOrder - 1));
                    }
                    // 完成环比
                    Double lastCompleteSingle = reportScales.stream().mapToDouble(ReportScale::getCompleteSingleQuantity).sum();
                    if (lastCompleteSingle.equals(zero)) {
                        scaleVO.setCompleteRingRatio("-");
                    } else {
                        scaleVO.setCompleteRingRatio(NumberUtils.formatDouble(collect5 / lastCompleteSingle - 1));
                    }
                } else {
                    // 单量环比
                    scaleVO.setQuantityRingRatio("-");
                    // 完成环比
                    scaleVO.setCompleteRingRatio("-");
                }
                scaleVOS.add(scaleVO);
            }
        }
        return scaleVOS;
    }


    /**
     * 根据查询条件查询数据
     *
     * @param cityId    城市id
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return
     */
    public List<ReportScale> listScale(Integer cityId, Integer startDate, Integer endDate) {
        QueryWrapper<ReportScale> queryWrapper = new QueryWrapper<>();
        if (cityId != null) {
            queryWrapper.eq("city_id", cityId);
        }
        queryWrapper.between("date", startDate, endDate).orderByAsc("create_time");
        return this.list(queryWrapper);
    }
}
