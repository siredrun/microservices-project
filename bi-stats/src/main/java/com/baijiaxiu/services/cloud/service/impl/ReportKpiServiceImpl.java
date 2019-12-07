package com.baijiaxiu.services.cloud.service.impl;

import com.baijiaxiu.services.cloud.common.utils.DateUtils;
import com.baijiaxiu.services.cloud.common.utils.NumberUtils;
import com.baijiaxiu.services.cloud.db.mapper.bi.ReportKpiMapper;
import com.baijiaxiu.services.cloud.entity.bi.ReportKpi;
import com.baijiaxiu.services.cloud.service.IReportKpiService;
import com.baijiaxiu.services.cloud.vo.ReportKpiVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * kpi报表 服务实现类
 * </p>
 *
 * @author liuyufeng
 * @since 2019-08-29
 */
@Service
public class ReportKpiServiceImpl extends ServiceImpl<ReportKpiMapper, ReportKpi> implements IReportKpiService {

    @Override
    public List<ReportKpiVO> listKpis(Integer cityId, Integer startDate, Integer endDate) {
        String zeroStr = "0%";
        Double zero = 0.0;
        List<ReportKpiVO> kpiVOS = new ArrayList<>();
        QueryWrapper<ReportKpi> queryWrapper = new QueryWrapper<>();
        if (cityId != null) {
            queryWrapper.eq("city_id", cityId);
        }
        queryWrapper.between("date", startDate, endDate);
        List<ReportKpi> list = this.list(queryWrapper);
        if (list != null) {
            // 根据城市分组
            Map<Integer, List<ReportKpi>> collect = list.stream().collect(Collectors.groupingBy(ReportKpi::getCityId));
            for (Map.Entry<Integer, List<ReportKpi>> listEntry : collect.entrySet()) {
                ReportKpiVO kpiVO = new ReportKpiVO();
                List<ReportKpi> cityKpi = listEntry.getValue();
                // 一小时联系率分子
                Double collect1 = cityKpi.stream().mapToDouble(ReportKpi::getOneHourContactRateNumerator).sum();
                // 一小时联系率分母
                Double collect2 = cityKpi.stream().mapToDouble(ReportKpi::getOneHourContactRateDenominator).sum();
                Double oneHourContactRate = collect1 / collect2;
                if (collect2.equals(zero)) {
                    kpiVO.setOneHourContactRate(zeroStr);
                } else {
                    kpiVO.setOneHourContactRate(NumberUtils.formatDouble(oneHourContactRate));
                }
                // 普通上门及时率分子
                Double collect3 = cityKpi.stream().mapToDouble(ReportKpi::getOrdinaryVisitTimeRateNumerator).sum();
                // 普通上门及时率分母
                Double collect4 = cityKpi.stream().mapToDouble(ReportKpi::getOrdinaryVisitTimeRateDenominator).sum();
                Double ordinaryVisitTimeRate = collect3 / collect4;
                if (collect4.equals(zero)) {
                    kpiVO.setOrdinaryVisitTimeRate(zeroStr);
                } else {
                    kpiVO.setOrdinaryVisitTimeRate(NumberUtils.formatDouble(ordinaryVisitTimeRate));
                }
                // 紧急3小时上门率分子
                Double collect5 = cityKpi.stream().mapToDouble(ReportKpi::getEmergencyThreeHourHomeRateNumerator).sum();
                // 紧急3小时上门率分母
                Double collect6 = cityKpi.stream().mapToDouble(ReportKpi::getEmergencyThreeHourHomeRateDenominator).sum();
                Double emergencyThreeHourHomeRate = collect5 / collect6;
                if (collect6.equals(zero)) {
                    kpiVO.setEmergencyThreeHourHomeRate(zeroStr);
                } else {
                    kpiVO.setEmergencyThreeHourHomeRate(NumberUtils.formatDouble(emergencyThreeHourHomeRate));
                }
                // 48小时完成率分子
                Double collect7 = cityKpi.stream().mapToDouble(ReportKpi::getFortyEightHourCompletionRateNumerator).sum();
                // 48小时完成率分母
                Double collect8 = cityKpi.stream().mapToDouble(ReportKpi::getFortyEightHourCompletionRateDenominator).sum();
                Double fortyEightHourCompletionRate = collect7 / collect8;
                if (collect8.equals(zero)) {
                    kpiVO.setFortyEightHourCompletionRate(zeroStr);
                } else {
                    kpiVO.setFortyEightHourCompletionRate(NumberUtils.formatDouble(fortyEightHourCompletionRate));
                }
                // 评价率分子
                Double collect9 = cityKpi.stream().mapToDouble(ReportKpi::getEvaluationOfRateNumerator).sum();
                // 评价率分母
                Double collect10 = cityKpi.stream().mapToDouble(ReportKpi::getEvaluationOfRateDenominator).sum();
                Double evaluationOfRate = collect9 / collect10;
                if (collect10.equals(zero)) {
                    kpiVO.setEvaluationOfRate(zeroStr);
                } else {
                    kpiVO.setEvaluationOfRate(NumberUtils.formatDouble(evaluationOfRate));
                }
                // 5星好评率分子
                Double collect11 = cityKpi.stream().mapToDouble(ReportKpi::getFiveStarRateNumerator).sum();
                // 5星好评率分母
                Double collect12 = cityKpi.stream().mapToDouble(ReportKpi::getFiveStarRateDenominator).sum();
                Double fiveStarRate = collect11 / collect12;
                if (collect12.equals(zero)) {
                    kpiVO.setFiveStarRate(zeroStr);
                } else {
                    kpiVO.setFiveStarRate(NumberUtils.formatDouble(fiveStarRate));
                }
                // 90天多次维修率分子
                Double collect13 = cityKpi.stream().mapToDouble(ReportKpi::getNinetyDaysMultipleMaintenanceRateNumerator).sum();
                // 90天多次维修率分母
                Double collect14 = cityKpi.stream().mapToDouble(ReportKpi::getNinetyDaysMultipleMaintenanceRateDenominator).sum();
                Double ninetyDaysMultipleMaintenanceRate = collect13 / collect14;
                if (collect14.equals(zero)) {
                    kpiVO.setNinetyDaysMultipleMaintenanceRate(zeroStr);
                } else {
                    kpiVO.setNinetyDaysMultipleMaintenanceRate(NumberUtils.formatDouble(ninetyDaysMultipleMaintenanceRate));
                }
                // 单均成本分子
                Double collect15 = cityKpi.stream().mapToDouble(ReportKpi::getSingleCostNumerator).sum();
                // 单均成本分母
                Double collect16 = cityKpi.stream().mapToDouble(ReportKpi::getSingleCostDenominator).sum();
                Double singleCost = collect15 / collect16;
                if (collect16.equals(zero)) {
                    kpiVO.setSingleCost("0.00");
                } else {
                    kpiVO.setSingleCost(NumberUtils.formatDouble(singleCost, 2));
                }
                // 人效超标率分子
                Long timeDiff = DateUtils.dayDiff(endDate.toString(), startDate.toString(), DateUtils.DATE_SIMPLE_PATTERN);
                timeDiff = timeDiff + 1;
                String startDateStr = DateUtils.strToDateFormat(startDate.toString(), DateUtils.DATE_SIMPLE_PATTERN, DateUtils.DATE_PATTERN);
                String endDateStr = DateUtils.strToDateFormat(endDate.toString(), DateUtils.DATE_SIMPLE_PATTERN, DateUtils.DATE_PATTERN);
                Double collect17 = this.baseMapper.getHumanEffectRateNumerator(cityKpi.get(0).getCityId(), startDateStr, endDateStr, timeDiff.intValue());
                // 人效超标率分母
                Double collect18 = this.baseMapper.getHumanEffectRateDenominator(cityKpi.get(0).getCityId(), startDateStr, endDateStr);
                Double humanEffectRate = collect17 / collect18;
                if (collect18.equals(zero)) {
                    kpiVO.setHumanEffectRate(zeroStr);
                } else {
                    kpiVO.setHumanEffectRate(NumberUtils.formatDouble(humanEffectRate));
                }
                kpiVO.setCityId(cityKpi.get(0).getCityId());
                kpiVO.setCityName(cityKpi.get(0).getCityName());
                kpiVOS.add(kpiVO);
            }
        }
        return kpiVOS;
    }

    @Override
    public Double getHumanEffectRateDenominator(Integer cityId, String startDate, String endDate) {
        return this.baseMapper.getHumanEffectRateDenominator(cityId, startDate, endDate);
    }
}
