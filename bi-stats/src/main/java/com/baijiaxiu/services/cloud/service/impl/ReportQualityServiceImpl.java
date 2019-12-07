package com.baijiaxiu.services.cloud.service.impl;

import com.baijiaxiu.services.cloud.common.utils.NumberUtils;
import com.baijiaxiu.services.cloud.db.mapper.bi.ReportQualityMapper;
import com.baijiaxiu.services.cloud.entity.bi.ReportQuality;
import com.baijiaxiu.services.cloud.service.IReportQualityService;
import com.baijiaxiu.services.cloud.vo.ReportQualityVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 品质报表 服务实现类
 * </p>
 *
 * @author liuyufeng
 * @since 2019-09-02
 */
@Service
public class ReportQualityServiceImpl extends ServiceImpl<ReportQualityMapper, ReportQuality> implements IReportQualityService {

    @Override
    public List<ReportQualityVO> listQualitys(Integer cityId, Integer startDate, Integer endDate) {
        String zeroStr = "0%";
        Double zero = 0.0;
        List<ReportQualityVO> qualityVOS = new ArrayList<>();
        QueryWrapper<ReportQuality> queryWrapper = new QueryWrapper<>();
        if (cityId != null) {
            queryWrapper.eq("city_id", cityId);
        }
        queryWrapper.between("date", startDate, endDate);
        List<ReportQuality> list = this.list(queryWrapper);
        if (list != null) {
            // 根据城市分组
            Map<Integer, List<ReportQuality>> collect = list.stream().collect(Collectors.groupingBy(ReportQuality::getCityId));
            for (Map.Entry<Integer, List<ReportQuality>> listEntry : collect.entrySet()) {
                ReportQualityVO qualityVO = new ReportQualityVO();
                List<ReportQuality> cityQuality = listEntry.getValue();
                // 当日完单量
                Double collect1 = cityQuality.stream().mapToDouble(ReportQuality::getDayCompleted).sum();
                qualityVO.setDayCompleted(String.valueOf(collect1.intValue()));
                // 当日评价单量
                Double collect2 = cityQuality.stream().mapToDouble(ReportQuality::getDayEvaluationQuantity).sum();
                qualityVO.setDayEvaluationQuantity(String.valueOf(collect2.intValue()));
                // 当日评价率
                Double collect3 = cityQuality.stream().mapToDouble(ReportQuality::getDayEvaluationRateNumerator).sum();
                Double collect4 = cityQuality.stream().mapToDouble(ReportQuality::getDayEvaluationRateDenominator).sum();
                Double dayEvaluationRate = collect3 / collect4;
                if (collect4.equals(zero)) {
                    qualityVO.setDayEvaluationRate(zeroStr);
                } else {
                    qualityVO.setDayEvaluationRate(NumberUtils.formatDouble(dayEvaluationRate));
                }
                // 当日5星好评率
                Double collect5 = cityQuality.stream().mapToDouble(ReportQuality::getDayFiveStarRatingNumerator).sum();
                Double collect6 = cityQuality.stream().mapToDouble(ReportQuality::getDayFiveStarRatingDenominator).sum();
                Double dayFiveStarRating = collect5 / collect6;
                if (collect6.equals(zero)) {
                    qualityVO.setDayFiveStarRating(zeroStr);
                } else {
                    qualityVO.setDayFiveStarRating(NumberUtils.formatDouble(dayFiveStarRating));
                }
                // 当日满意率
                Double collect7 = cityQuality.stream().mapToDouble(ReportQuality::getDaySatisfactionRateNumerator).sum();
                Double collect8 = cityQuality.stream().mapToDouble(ReportQuality::getDaySatisfactionRateDenominator).sum();
                Double daySatisfactionRate = collect7 / collect8;
                if (collect8.equals(zero)) {
                    qualityVO.setDaySatisfactionRate(zeroStr);
                } else {
                    qualityVO.setDaySatisfactionRate(NumberUtils.formatDouble(daySatisfactionRate));
                }
                ReportQuality reportQuality = cityQuality.get(cityQuality.size() - 1);
                // 累计完成单量
                Double totalCompleted = reportQuality.getTotalCompleted();
                qualityVO.setTotalCompleted(String.valueOf(totalCompleted.intValue()));
                // 累计评价单量
                Double totalEvaluationQuantity = reportQuality.getTotalEvaluationQuantity();
                qualityVO.setTotalEvaluationQuantity(String.valueOf(totalEvaluationQuantity.intValue()));
                // 累计评价率
                if (totalCompleted.equals(zero)) {
                    qualityVO.setTotalEvaluationRate(zeroStr);
                } else {
                    qualityVO.setTotalEvaluationRate(NumberUtils.formatDouble(totalEvaluationQuantity / totalCompleted));
                }
                // 累计5星好评
                Double totalFiveStarRatingNumerator = reportQuality.getTotalFiveStarRatingNumerator();
                Double totalFiveStarRatingDenominator = reportQuality.getTotalFiveStarRatingDenominator();
                if (totalFiveStarRatingDenominator.equals(zero)) {
                    qualityVO.setTotalFiveStarRating(zeroStr);
                } else {
                    qualityVO.setTotalFiveStarRating(NumberUtils.formatDouble(totalFiveStarRatingNumerator / totalFiveStarRatingDenominator));
                }
                // 累计满意
                Double totalSatisfactionRateNumerator = reportQuality.getTotalSatisfactionRateNumerator();
                Double totalSatisfactionRateDenominator = reportQuality.getTotalSatisfactionRateDenominator();
                if (totalSatisfactionRateDenominator.equals(zero)) {
                    qualityVO.setTotalSatisfactionRate(zeroStr);
                } else {
                    qualityVO.setTotalSatisfactionRate(NumberUtils.formatDouble(totalSatisfactionRateNumerator / totalSatisfactionRateDenominator));
                }

                qualityVO.setCityId(reportQuality.getCityId());
                qualityVO.setCityName(reportQuality.getCityName());
                qualityVOS.add(qualityVO);
            }
        }
        return qualityVOS;
    }
}
