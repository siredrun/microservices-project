package com.baijiaxiu.services.cloud.service.impl;

import com.baijiaxiu.services.cloud.common.utils.NumberUtils;
import com.baijiaxiu.services.cloud.db.mapper.bi.ReportCostMapper;
import com.baijiaxiu.services.cloud.entity.bi.ReportCost;
import com.baijiaxiu.services.cloud.service.IReportCostService;
import com.baijiaxiu.services.cloud.vo.ReportCostVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 成本报表 服务实现类
 * </p>
 *
 * @author liuyufeng
 * @since 2019-09-03
 */
@Service
public class ReportCostServiceImpl extends ServiceImpl<ReportCostMapper, ReportCost> implements IReportCostService {

    @Override
    public List<ReportCostVO> listCosts(Integer cityId, Integer startDate, Integer endDate) {
        String zeroStr = "0.00";
        Double zero = 0.0;
        List<ReportCostVO> costVOS = new ArrayList<>();
        QueryWrapper<ReportCost> queryWrapper = new QueryWrapper<>();
        if (cityId != null) {
            queryWrapper.eq("city_id", cityId);
        }
        queryWrapper.between("date", startDate, endDate);
        List<ReportCost> list = this.list(queryWrapper);
        if (list != null) {
            // 根据城市分组
            Map<Integer, List<ReportCost>> collect = list.stream().collect(Collectors.groupingBy(ReportCost::getCityId));
            for (Map.Entry<Integer, List<ReportCost>> listEntry : collect.entrySet()) {
                ReportCostVO costVO = new ReportCostVO();
                List<ReportCost> cityCost = listEntry.getValue();
                // 总单均
                Double collect1 = cityCost.stream().mapToDouble(ReportCost::getTotalAverageNumerator).sum();
                Double collect2 = cityCost.stream().mapToDouble(ReportCost::getTotalAverageDenominator).sum();
                Double totalAverage = collect1 / collect2;
                if (collect2.equals(zero)) {
                    costVO.setTotalAverage(zeroStr);
                } else {
                    costVO.setTotalAverage(NumberUtils.formatDouble(totalAverage, 2));
                }
                // 综合单均
                Double collect3 = cityCost.stream().mapToDouble(ReportCost::getSynthesizeAverageNumerator).sum();
                Double collect4 = cityCost.stream().mapToDouble(ReportCost::getSynthesizeAverageDenominator).sum();
                Double synthesizeAverage = collect3 / collect4;
                if (collect4.equals(zero)) {
                    costVO.setSynthesizeAverage(zeroStr);
                } else {
                    costVO.setSynthesizeAverage(NumberUtils.formatDouble(synthesizeAverage, 2));
                }
                // 电器单均
                Double collect5 = cityCost.stream().mapToDouble(ReportCost::getElectricalAverageNumerator).sum();
                Double collect6 = cityCost.stream().mapToDouble(ReportCost::getElectricalAverageDenominator).sum();
                Double electricalAverage = collect5 / collect6;
                if (collect6.equals(zero)) {
                    costVO.setElectricalAverage(zeroStr);
                } else {
                    costVO.setElectricalAverage(NumberUtils.formatDouble(electricalAverage, 2));
                }
                // 混合单均
                Double collect7 = cityCost.stream().mapToDouble(ReportCost::getMixtureAverageNumerator).sum();
                Double collect8 = cityCost.stream().mapToDouble(ReportCost::getMixtureAverageDenominator).sum();
                Double mixtureAverage = collect7 / collect8;
                if (collect8.equals(zero)) {
                    costVO.setMixtureAverage(zeroStr);
                } else {
                    costVO.setMixtureAverage(NumberUtils.formatDouble(mixtureAverage, 2));
                }
                costVO.setCityId(cityCost.get(0).getCityId());
                costVO.setCityName(cityCost.get(0).getCityName());
                costVOS.add(costVO);
            }
        }
        return costVOS;
    }
}
