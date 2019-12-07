package com.baijiaxiu.services.cloud.service.impl;

import com.baijiaxiu.services.cloud.db.mapper.bi.ReportOrderTypeMapper;
import com.baijiaxiu.services.cloud.entity.bi.ReportOrderType;
import com.baijiaxiu.services.cloud.service.IReportOrderTypeService;
import com.baijiaxiu.services.cloud.vo.ReportOrderTypeVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 工单类型报表 服务实现类
 * </p>
 *
 * @author liuyufeng
 * @since 2019-09-03
 */
@Service
public class ReportOrderTypeServiceImpl extends ServiceImpl<ReportOrderTypeMapper, ReportOrderType> implements IReportOrderTypeService {

    @Override
    public List<ReportOrderTypeVO> listOrderTypes(Integer cityId, Integer startDate, Integer endDate) {
        List<ReportOrderTypeVO> typeVOS = new ArrayList<>();
        QueryWrapper<ReportOrderType> queryWrapper = new QueryWrapper<>();
        if (cityId != null) {
            queryWrapper.eq("city_id", cityId);
        }
        queryWrapper.between("date", startDate, endDate);
        List<ReportOrderType> list = this.list(queryWrapper);
        if (list != null) {
            // 根据城市分组
            Map<Integer, List<ReportOrderType>> collect = list.stream().collect(Collectors.groupingBy(ReportOrderType::getCityId));
            for (Map.Entry<Integer, List<ReportOrderType>> listEntry : collect.entrySet()) {
                ReportOrderTypeVO typeVO = new ReportOrderTypeVO();
                List<ReportOrderType> cityOrderType = listEntry.getValue();
                // 单量
                Double collect15 = cityOrderType.stream().mapToDouble(ReportOrderType::getOrderNum).sum();
                typeVO.setOrderNum(String.valueOf(collect15.intValue()));
                // 综合单量
                Double collect1 = cityOrderType.stream().mapToDouble(ReportOrderType::getSynthesizeNum).sum();
                typeVO.setSynthesizeNum(String.valueOf(collect1.intValue()));
                // 完成的综合单量
                Double collect2 = cityOrderType.stream().mapToDouble(ReportOrderType::getSynthesizeFinishNum).sum();
                typeVO.setSynthesizeFinishNum(String.valueOf(collect2.intValue()));
                // 电器单量
                Double collect3 = cityOrderType.stream().mapToDouble(ReportOrderType::getElectricNum).sum();
                typeVO.setElectricNum(String.valueOf(collect3.intValue()));
                // 完成的电器单量
                Double collect4 = cityOrderType.stream().mapToDouble(ReportOrderType::getElectricFinishNum).sum();
                typeVO.setElectricFinishNum(String.valueOf(collect4.intValue()));
                // 综合电器单量
                Double collect5 = cityOrderType.stream().mapToDouble(ReportOrderType::getSynElectricNum).sum();
                typeVO.setSynElectricNum(String.valueOf(collect5.intValue()));
                // 完成的综合电器单量
                Double collect6 = cityOrderType.stream().mapToDouble(ReportOrderType::getSynElectricFinishNum).sum();
                typeVO.setSynElectricFinishNum(String.valueOf(collect6.intValue()));
                // 防水单量
                Double collect7 = cityOrderType.stream().mapToDouble(ReportOrderType::getWaterproofNum).sum();
                typeVO.setWaterproofNum(String.valueOf(collect7.intValue()));
                // 完成的防水单量
                Double collect8 = cityOrderType.stream().mapToDouble(ReportOrderType::getWaterproofFinishNum).sum();
                typeVO.setWaterproofFinishNum(String.valueOf(collect8.intValue()));
                // 报修单量
                Double collect9 = cityOrderType.stream().mapToDouble(ReportOrderType::getRepairNum).sum();
                typeVO.setRepairNum(String.valueOf(collect9.intValue()));
                // 返工单量
                Double collect10 = cityOrderType.stream().mapToDouble(ReportOrderType::getReworkNum).sum();
                typeVO.setReworkNum(String.valueOf(collect10.intValue()));
                // 巡房单量
                Double collect11 = cityOrderType.stream().mapToDouble(ReportOrderType::getRoundHouseNum).sum();
                typeVO.setRoundHouseNum(String.valueOf(collect11.intValue()));
                // 退租单量
                Double collect12 = cityOrderType.stream().mapToDouble(ReportOrderType::getSurrenderNum).sum();
                typeVO.setSurrenderNum(String.valueOf(collect12.intValue()));
                // 巡检单量
                Double collect13 = cityOrderType.stream().mapToDouble(ReportOrderType::getPollingNum).sum();
                typeVO.setPollingNum(String.valueOf(collect13.intValue()));
                // 撤销单量
                Double collect14 = cityOrderType.stream().mapToDouble(ReportOrderType::getBackoutNum).sum();
                typeVO.setBackoutNum(String.valueOf(collect14.intValue()));
                // 当月累计单量
                ReportOrderType lastOrderType = cityOrderType.get(cityOrderType.size() - 1);
                typeVO.setMonthOrderNum(String.valueOf(lastOrderType.getMonthOrderNum().intValue()));
                // 当月累计综合单量
                typeVO.setMonthSynthesizeNum(String.valueOf(lastOrderType.getMonthSynthesizeNum().intValue()));
                // 当月累计完成综合单量
                typeVO.setMonthSynthesizeFinishNum(String.valueOf(lastOrderType.getMonthSynthesizeFinishNum().intValue()));
                // 当月累计电器单量
                typeVO.setMonthElectricNum(String.valueOf(lastOrderType.getMonthElectricNum().intValue()));
                // 当月累计完成电器单量
                typeVO.setMonthElectricFinishNum(String.valueOf(lastOrderType.getMonthElectricFinishNum().intValue()));
                // 当月累计综合电器单量
                typeVO.setMonthSynElectricNum(String.valueOf(lastOrderType.getMonthSynElectricNum().intValue()));
                // 当月综合累计完成电器单量
                typeVO.setMonthSynElectricFinishNum(String.valueOf(lastOrderType.getMonthSynElectricFinishNum().intValue()));
                // 当月累计防水单量
                typeVO.setMonthWaterproofNum(String.valueOf(lastOrderType.getMonthWaterproofNum().intValue()));
                // 当月累计完成防水单量
                typeVO.setMonthWaterproofFinishNum(String.valueOf(lastOrderType.getMonthWaterproofFinishNum().intValue()));
                // 当月累计报修单量
                typeVO.setMonthRepairNum(String.valueOf(lastOrderType.getMonthRepairNum().intValue()));
                // 当月累计返工单量
                typeVO.setMonthReworkNum(String.valueOf(lastOrderType.getMonthReworkNum().intValue()));
                // 当月累计巡房单量
                typeVO.setMonthRoundHouseNum(String.valueOf(lastOrderType.getMonthRoundHouseNum().intValue()));
                // 当月累计退租单量
                typeVO.setMonthSurrenderNum(String.valueOf(lastOrderType.getMonthSurrenderNum().intValue()));
                // 当月累计巡检单量
                typeVO.setMonthPollingNum(String.valueOf(lastOrderType.getMonthPollingNum().intValue()));
                // 当月累计撤销单量
                typeVO.setMonthBackoutNum(String.valueOf(lastOrderType.getMonthBackoutNum().intValue()));
                typeVO.setCityId(lastOrderType.getCityId());
                typeVO.setCityName(lastOrderType.getCityName());
                typeVOS.add(typeVO);
            }
        }
        return typeVOS;
    }
}
