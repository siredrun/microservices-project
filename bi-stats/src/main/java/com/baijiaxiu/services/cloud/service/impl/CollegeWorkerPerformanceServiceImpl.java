package com.baijiaxiu.services.cloud.service.impl;

import com.baijiaxiu.services.cloud.db.mapper.bi.CollegeWorkerPerformanceMapper;
import com.baijiaxiu.services.cloud.dto.WorkerPerformanceDTO;
import com.baijiaxiu.services.cloud.entity.bi.CollegeWorkerPerformance;
import com.baijiaxiu.services.cloud.service.ICollegeWorkerPerformanceService;
import com.baijiaxiu.services.cloud.vo.WorkerPerformanceVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liuyufeng
 * @since 2019-11-28
 */
@Service
public class CollegeWorkerPerformanceServiceImpl extends ServiceImpl<CollegeWorkerPerformanceMapper, CollegeWorkerPerformance> implements ICollegeWorkerPerformanceService {
    @Override
    public WorkerPerformanceVO getWorkerPerformanceVO(WorkerPerformanceDTO workerPerformerceDTO) {
        Double zero = 0.0;
        String zeroStr = zero.toString();
        WorkerPerformanceVO workerPerformanceVO = new WorkerPerformanceVO();
        QueryWrapper<CollegeWorkerPerformance> queryWrapper = new QueryWrapper<>();
        if (workerPerformerceDTO.getWorkerId() != null) {
            queryWrapper.eq("worker_id", workerPerformerceDTO.getWorkerId());
        }
        String startDate = workerPerformerceDTO.getStartDate().replace("-", "");
        String endDate = workerPerformerceDTO.getEndDate().replace("-", "");
        QueryWrapper<CollegeWorkerPerformance> date = queryWrapper.between("date", startDate, endDate);
        BigDecimal bigDecimal;
        List<CollegeWorkerPerformance> list = this.list(queryWrapper);
        if (list != null) {
            // 根据师傅Id
            Map<Integer, List<CollegeWorkerPerformance>> collect = list.stream().collect(Collectors.groupingBy(CollegeWorkerPerformance::getWorkerId));

            for (Map.Entry<Integer, List<CollegeWorkerPerformance>> listEntry : collect.entrySet()) {
                List<CollegeWorkerPerformance> workerPerformances = listEntry.getValue();

                // 联系及时率
                Double collect1 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getContactOntimeNumerator).sum();
                Double collect2 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getContactOntimeDenominator).sum();
                Double contactOntime = collect1 / collect2;
                if (collect2.equals(zero)) {
                    workerPerformanceVO.setContactOntime(zeroStr);
                } else {
                    workerPerformanceVO.setContactOntime(String.format("%.4f", contactOntime));
                }
                // 完成率
                Double collect3 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getFinishNumerator).sum();
                Double collect4 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getFinishDenominator).sum();
                Double finish = collect3 / collect4;
                if (collect4.equals(zero)) {
                    workerPerformanceVO.setFinish(zeroStr);
                } else {
                    workerPerformanceVO.setFinish(String.format("%.4f", finish));
                }
                // 综合单均成本
                Double collect5 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getSynthesizeAvgrageNumerator).sum();
                Double collect6 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getSynthesizeAvgrageDenominator).sum();
                Double synthesizeAvgrage = collect5 / collect6;
                if (collect6.equals(zero)) {
                    workerPerformanceVO.setSynthesizeAvgrage(zeroStr);
                } else {
                    workerPerformanceVO.setSynthesizeAvgrage(String.format("%.2f", synthesizeAvgrage));
                }
                // 电器单均成本
                Double collect7 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getElectricalAvgrateNumerator).sum();
                Double collect8 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getElectricalAvgrateDenominator).sum();
                Double electricalAvgrate = collect7 / collect8;
                if (collect8.equals(zero)) {
                    workerPerformanceVO.setElectricalAvgrate(zeroStr);
                } else {
                    workerPerformanceVO.setElectricalAvgrate(String.format("%.2f", electricalAvgrate));
                }
                // 综合电器单均成本
                Double collect9 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getMixtureAvgrateNumerator).sum();
                Double collect10 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getMixtureAvgrateNumerator).sum();
                Double mixtureAvgrate = collect9 / collect10;
                if (collect10.equals(zero)) {
                    workerPerformanceVO.setMixtureAvgrate(zeroStr);
                } else {
                    workerPerformanceVO.setMixtureAvgrate(String.format("%.2f", mixtureAvgrate));
                }
                // 90天重复维修率
                Double collect11 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getNinetyReworkNumerator).sum();
                Double collect12 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getNinetyReworkDenominator).sum();
                Double ninetyRework = collect11 / collect12;
                if (collect12.equals(zero)) {
                    workerPerformanceVO.setNinetyRework(zeroStr);
                } else {
                    workerPerformanceVO.setNinetyRework(String.format("%.4f", ninetyRework));
                }
                // 紧急三小时上门率
                Double collect13 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getVisitOntimeExigencyNumerator).sum();
                Double collect14 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getVisitOntimeExigencyDenominator).sum();
                Double visitOntimeExigency = collect13 / collect14;
                if (collect14.equals(zero)) {
                    workerPerformanceVO.setVisitOntimeExigency(zeroStr);
                } else {
                    workerPerformanceVO.setVisitOntimeExigency(String.format("%.4f", visitOntimeExigency));
                }
                // 评价平均分
                Double collect15 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getAvgScoreNumerator).sum();
                Double collect16 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getAvgScoreDenominator).sum();
                Double avgScore = collect15 / collect16;
                if (collect16.equals(zero)) {
                    workerPerformanceVO.setAvgScore(zeroStr);
                } else {
                    workerPerformanceVO.setAvgScore(String.format("%.2f", avgScore));
                }
                // 方案一次通过率
                Double collect17 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getProgramPassrateOnetimeNumerator).sum();
                Double collect18 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getProgramPassrateOnetimeDenominator).sum();
                Double programPassrateOnetime = collect17 / collect18;
                if (collect18.equals(zero)) {
                    workerPerformanceVO.setProgramPassrateOnetime(zeroStr);
                } else {
                    workerPerformanceVO.setProgramPassrateOnetime(String.format("%.4f", programPassrateOnetime));
                }
                // 普通上门及时率
                Double collect19 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getVisitOntimeNumerator).sum();
                Double collect20 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getVisitOntimeDenominator).sum();
                Double visitOntime = collect19 / collect20;
                if (collect20.equals(zero)) {
                    workerPerformanceVO.setVisitOntime(zeroStr);
                } else {
                    workerPerformanceVO.setVisitOntime(String.format("%.4f", visitOntime));
                }
                // 评价率
                Double collect21 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getEvaluateNumerator).sum();
                Double collect22 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getEvaluateDenominator).sum();
                Double evaluate = collect21 / collect22;
                if (collect22.equals(zero)) {
                    workerPerformanceVO.setEvaluate(zeroStr);
                } else {
                    workerPerformanceVO.setEvaluate(String.format("%.4f", evaluate));
                }
                // 五星好评率
                Double collect23 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getFiveStartEvaluateNumerator).sum();
                Double collect24 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getFiveStartEvaluateDenominator).sum();
                Double fiveStartEvaluate = collect23 / collect24;
                if (collect24.equals(zero)) {
                    workerPerformanceVO.setFiveStartEvaluate(zeroStr);
                } else {
                    workerPerformanceVO.setFiveStartEvaluate(String.format("%.4f", fiveStartEvaluate));
                }
                // 防水单均成本
                Double collect25 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getWaterproofAvgrateNumerator).sum();
                Double collect26 = workerPerformances.stream().mapToDouble(CollegeWorkerPerformance::getWaterproofAvgrateDenominator).sum();
                Double waterproofAvgrate = collect25 / collect26;
                if (collect26.equals(zero)) {
                    workerPerformanceVO.setWaterproofAvgrate(zeroStr);
                } else {
                    workerPerformanceVO.setWaterproofAvgrate(String.format("%.2f", waterproofAvgrate));
                }
                CollegeWorkerPerformance collegeWorkerPerformance = workerPerformances.get(workerPerformances.size() - 1);
                // 疑难量
                Double difficultOrderNum = collegeWorkerPerformance.getDifficultOrderNum();
                workerPerformanceVO.setDifficultOrderNum(String.valueOf(Integer.valueOf(difficultOrderNum.intValue())));
                // 师傅Id
                workerPerformanceVO.setWorkerId(collegeWorkerPerformance.getWorkerId());
                // 师傅名字
                workerPerformanceVO.setWorkerName(collegeWorkerPerformance.getWorkerName());
            }
        }
        return workerPerformanceVO;
    }
}
