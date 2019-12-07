package com.baijiaxiu.services.cloud.service.impl;

import com.baijiaxiu.services.cloud.common.utils.DateUtils;
import com.baijiaxiu.services.cloud.common.utils.NumberUtils;
import com.baijiaxiu.services.cloud.db.mapper.bi.ReportEffectMapper;
import com.baijiaxiu.services.cloud.entity.bi.ReportEffect;
import com.baijiaxiu.services.cloud.service.IReportEffectService;
import com.baijiaxiu.services.cloud.vo.ReportEffectVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 时效报表 服务实现类
 * </p>
 *
 * @author liuyufeng
 * @since 2019-09-04
 */
@Service
public class ReportEffectServiceImpl extends ServiceImpl<ReportEffectMapper, ReportEffect> implements IReportEffectService {
    final String zeroStr = "0%";
    final Double zero = 0.0;

    @Override
    public List<ReportEffectVO> listEffects(Integer cityId, Integer startDate, Integer endDate) {

        List<ReportEffectVO> effectVOS = new ArrayList<>();
        QueryWrapper<ReportEffect> queryWrapper = new QueryWrapper<>();
        if (cityId != null) {
            queryWrapper.eq("city_id", cityId);
        }
        queryWrapper.between("date", startDate, endDate);
        List<ReportEffect> list = this.list(queryWrapper);
        if (list != null) {
            // 根据城市分组
            Map<Integer, List<ReportEffect>> collect = list.stream().collect(Collectors.groupingBy(ReportEffect::getCityId));
            for (Map.Entry<Integer, List<ReportEffect>> listEntry : collect.entrySet()) {
                ReportEffectVO effectVO = new ReportEffectVO();
                List<ReportEffect> cityEffect = listEntry.getValue();

                // 创建总单量
                Double collect0 = cityEffect.stream().mapToDouble(ReportEffect::getOrderNum).sum();
                effectVO.setOrderNum(collect0.intValue());

                // 联系单量
                Double collect1 = cityEffect.stream().mapToDouble(ReportEffect::getContactNum).sum();
                effectVO.setContactNum(collect1.toString());
                // 1小时联系及时率
                Double collect2 = cityEffect.stream().mapToDouble(ReportEffect::getContactOntimeNumerator).sum();
                Double collect3 = cityEffect.stream().mapToDouble(ReportEffect::getContactOntimeDenominator).sum();
                Double contactOntime = collect2 / collect3;
                if (collect3.equals(zero)) {
                    effectVO.setContactOntime(zeroStr);
                } else {
                    effectVO.setContactOntime(NumberUtils.formatDouble(contactOntime));
                }
                // 紧急单量
                Double collect4 = cityEffect.stream().mapToDouble(ReportEffect::getExigencyNum).sum();
                effectVO.setExigencyNum(collect4.toString());
                // 紧急3小时上门率
                Double collect5 = cityEffect.stream().mapToDouble(ReportEffect::getVisitOntimeExigencyNumerator).sum();
                Double collect6 = cityEffect.stream().mapToDouble(ReportEffect::getVisitOntimeExigencyDenominator).sum();
                Double visitOntimeExigency = collect5 / collect6;
                if (collect6.equals(zero)) {
                    effectVO.setVisitOntimeExigency(zeroStr);
                } else {
                    effectVO.setVisitOntimeExigency(NumberUtils.formatDouble(visitOntimeExigency));
                }
                // 一次上门及时率
                Double collect7 = cityEffect.stream().mapToDouble(ReportEffect::getVisitOntimeFirstNumerator).sum();
                Double collect8 = cityEffect.stream().mapToDouble(ReportEffect::getVisitOntimeFirstDenominator).sum();
                Double visitOntimeFirst = collect7 / collect8;
                if (collect8.equals(zero)) {
                    effectVO.setVisitOntimeFirst(zeroStr);
                } else {
                    effectVO.setVisitOntimeFirst(NumberUtils.formatDouble(visitOntimeFirst));
                }
                // 上门及时率
                Double collect9 = cityEffect.stream().mapToDouble(ReportEffect::getVisitOntimeChangeNumerator).sum();
                Double collect10 = cityEffect.stream().mapToDouble(ReportEffect::getVisitOntimeChangeDenominator).sum();
                Double visitOntimeChange = collect9 / collect10;
                if (collect10.equals(zero)) {
                    effectVO.setVisitOntimeChange(zeroStr);
                } else {
                    effectVO.setVisitOntimeChange(NumberUtils.formatDouble(visitOntimeChange));
                }
                // 上门单量
                Double collect11 = cityEffect.stream().mapToDouble(ReportEffect::getVisitNum).sum();
                effectVO.setVisitNum(collect11.toString());
                // 4小时反馈率
                Double collect12 = cityEffect.stream().mapToDouble(ReportEffect::getFeedbackOntimeNumerator).sum();
                Double collect13 = cityEffect.stream().mapToDouble(ReportEffect::getFeedbackOntimeDenominator).sum();
                Double feedbackOntime = collect12 / collect13;
                if (collect13.equals(zero)) {
                    effectVO.setFeedbackOntime(zeroStr);
                } else {
                    effectVO.setFeedbackOntime(NumberUtils.formatDouble(feedbackOntime));
                }
                // 完成单量
                Double collect14 = cityEffect.stream().mapToDouble(ReportEffect::getFinishNum).sum();
                effectVO.setFinishNum(collect14.toString());
                // 24小时完成率
                Double collect15 = cityEffect.stream().mapToDouble(ReportEffect::getTwentyFourFinishrateNumerator).sum();
                Double collect16 = cityEffect.stream().mapToDouble(ReportEffect::getTwentyFourFinishrateDenominator).sum();
                Double twentyFourFinishrate = collect15 / collect16;
                if (collect13.equals(zero)) {
                    effectVO.setTwentyFourFinishrate(zeroStr);
                } else {
                    effectVO.setTwentyFourFinishrate(NumberUtils.formatDouble(twentyFourFinishrate));
                }
                // 48小时完成率
                Double collect17 = cityEffect.stream().mapToDouble(ReportEffect::getFortyEightFinishrateNumerator).sum();
                Double collect18 = cityEffect.stream().mapToDouble(ReportEffect::getFortyEightFinishrateDenominator).sum();
                Double fortyEightFinishrate = collect17 / collect18;
                if (collect18.equals(zero)) {
                    effectVO.setFortyEightFinishrate(zeroStr);
                } else {
                    effectVO.setFortyEightFinishrate(NumberUtils.formatDouble(fortyEightFinishrate));
                }
                // 完成率
                Double collect19 = cityEffect.stream().mapToDouble(ReportEffect::getFinishRateNumerator).sum();
                Double collect20 = cityEffect.stream().mapToDouble(ReportEffect::getFinishRateDenominator).sum();
                Double finishRate = collect19 / collect20;
                if (collect20.equals(zero)) {
                    effectVO.setFinishRate(zeroStr);
                } else {
                    effectVO.setFinishRate(NumberUtils.formatDouble(finishRate));
                }
                ReportEffectVO calculation = calculation(effectVO, cityEffect.get(0).getCityId(), startDate, endDate);
                calculation.setCityId(cityEffect.get(0).getCityId());
                calculation.setCityName(cityEffect.get(0).getCityName());
                effectVOS.add(calculation);
            }
        }
        return effectVOS;
    }

    /**
     * 计算环比
     *
     * @param effectVO
     * @param cityId
     * @param startDate
     * @param endDate
     * @return
     */
    private ReportEffectVO calculation(ReportEffectVO effectVO, Integer cityId, Integer startDate, Integer endDate) {
        String[] ringRatioTime = DateUtils.linkRelativeDate(startDate.toString(), endDate.toString(), DateUtils.DATE_SIMPLE_PATTERN);
        List<ReportEffect> effects = listEffect(cityId, Integer.valueOf(ringRatioTime[0]), Integer.valueOf(ringRatioTime[1]));
        if (effects != null && effects.size() > 0) {
            // 1小时联系及时率环比
            Double collect1 = effects.stream().mapToDouble(ReportEffect::getContactOntimeNumerator).sum();
            Double collect2 = effects.stream().mapToDouble(ReportEffect::getContactOntimeDenominator).sum();
            Double oldContactOntime = collect1 / collect2;
            String nowContactOntime = effectVO.getContactOntime();
            if (oldContactOntime.equals(zero) || oldContactOntime.isNaN()) {
                effectVO.setContactOntimeRingRatio(zeroStr);
            } else {
                Double aDouble = this.formatDouble(nowContactOntime);
                effectVO.setContactOntimeRingRatio(NumberUtils.formatDouble(aDouble / oldContactOntime - 1));
            }
            // 紧急3小时上门率环比
            Double collect3 = effects.stream().mapToDouble(ReportEffect::getVisitOntimeExigencyNumerator).sum();
            Double collect4 = effects.stream().mapToDouble(ReportEffect::getVisitOntimeExigencyDenominator).sum();
            Double oldVisitOntimeExigency = collect3 / collect4;
            String nowVisitOntimeExigency = effectVO.getVisitOntimeExigency();
            if (oldVisitOntimeExigency.equals(zero) || oldVisitOntimeExigency.isNaN()) {
                effectVO.setVisitOntimeExigencyRingRatio(zeroStr);
            } else {
                Double voeDouble = this.formatDouble(nowVisitOntimeExigency);
                effectVO.setVisitOntimeExigencyRingRatio(NumberUtils.formatDouble(voeDouble / oldVisitOntimeExigency - 1));
            }
            // 一次上门及时率环比
            Double collect5 = effects.stream().mapToDouble(ReportEffect::getVisitOntimeFirstNumerator).sum();
            Double collect6 = effects.stream().mapToDouble(ReportEffect::getVisitOntimeFirstDenominator).sum();
            Double oldVisitOntimeFirst = collect5 / collect6;
            String nowVisitOntimeFirst = effectVO.getVisitOntimeFirst();
            if (oldVisitOntimeFirst.equals(zero) || oldVisitOntimeFirst.isNaN()) {
                effectVO.setVisitOntimeFirstRingRatio(zeroStr);
            } else {
                Double vofDouble = this.formatDouble(nowVisitOntimeFirst);
                effectVO.setVisitOntimeFirstRingRatio(NumberUtils.formatDouble(vofDouble / oldVisitOntimeFirst - 1));
            }
            // 上门及时率环比
            Double collect7 = effects.stream().mapToDouble(ReportEffect::getVisitOntimeChangeNumerator).sum();
            Double collect8 = effects.stream().mapToDouble(ReportEffect::getVisitOntimeChangeDenominator).sum();
            Double oldVisitOntimeChange = collect7 / collect8;
            String nowVisitOntimeChange = effectVO.getVisitOntimeChange();
            if (oldVisitOntimeChange.equals(zero) || oldVisitOntimeChange.isNaN()) {
                effectVO.setVisitOntimeChangeRingRatio(zeroStr);
            } else {
                Double vocDouble = this.formatDouble(nowVisitOntimeChange);
                effectVO.setVisitOntimeChangeRingRatio(NumberUtils.formatDouble(vocDouble / oldVisitOntimeChange - 1));
            }
            // 4小时反馈率环比
            Double collect9 = effects.stream().mapToDouble(ReportEffect::getFeedbackOntimeNumerator).sum();
            Double collect10 = effects.stream().mapToDouble(ReportEffect::getFeedbackOntimeDenominator).sum();
            Double oldFeedbackOntime = collect9 / collect10;
            String nowFeedbackOntime = effectVO.getFeedbackOntime();
            if (oldFeedbackOntime.equals(zero) || oldFeedbackOntime.isNaN()) {
                effectVO.setFeedbackOntimeRingRatio(zeroStr);
            } else {
                Double fboDouble = this.formatDouble(nowFeedbackOntime);
                effectVO.setFeedbackOntimeRingRatio(NumberUtils.formatDouble(fboDouble / oldFeedbackOntime - 1));
            }
            // 24小时完成率环比
            Double collect11 = effects.stream().mapToDouble(ReportEffect::getTwentyFourFinishrateNumerator).sum();
            Double collect12 = effects.stream().mapToDouble(ReportEffect::getTwentyFourFinishrateDenominator).sum();
            Double oldTwentyFourFinishrate = collect11 / collect12;
            String nowTwentyFourFinishrate = effectVO.getTwentyFourFinishrate();
            if (oldTwentyFourFinishrate.equals(zero) || oldTwentyFourFinishrate.isNaN()) {
                effectVO.setTwentyFourFinishrateRingRatio(zeroStr);
            } else {
                Double tffDouble = this.formatDouble(nowTwentyFourFinishrate);
                effectVO.setTwentyFourFinishrateRingRatio(NumberUtils.formatDouble(tffDouble / oldTwentyFourFinishrate - 1));
            }
            // 48小时完成率环比
            Double collect13 = effects.stream().mapToDouble(ReportEffect::getFortyEightFinishrateNumerator).sum();
            Double collect14 = effects.stream().mapToDouble(ReportEffect::getFortyEightFinishrateDenominator).sum();
            Double oldFortyEightFinishrate = collect13 / collect14;
            String nowFortyEightFinishrate = effectVO.getFortyEightFinishrate();
            if (oldFortyEightFinishrate.equals(zero) || oldFortyEightFinishrate.isNaN()) {
                effectVO.setFortyEightFinishrateRingRatio(zeroStr);
            } else {
                Double tefDouble = this.formatDouble(nowFortyEightFinishrate);
                effectVO.setFortyEightFinishrateRingRatio(NumberUtils.formatDouble(tefDouble / oldFortyEightFinishrate - 1));
            }
        } else {
            // 1小时联系及时率环比
            effectVO.setContactOntimeRingRatio(zeroStr);
            // 紧急3小时上门率环比
            effectVO.setVisitOntimeExigencyRingRatio(zeroStr);
            // 一次上门及时率环比
            effectVO.setVisitOntimeFirstRingRatio(zeroStr);
            // 上门及时率环比
            effectVO.setVisitOntimeChangeRingRatio(zeroStr);
            // 4小时反馈率环比
            effectVO.setFeedbackOntimeRingRatio(zeroStr);
            // 24小时完成率环比
            effectVO.setTwentyFourFinishrateRingRatio(zeroStr);
            // 48小时完成率环比
            effectVO.setFortyEightFinishrateRingRatio(zeroStr);
        }
        return effectVO;
    }


    /**
     * 根据查询条件查询数据
     *
     * @param cityId    城市id
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return
     */
    public List<ReportEffect> listEffect(Integer cityId, Integer startDate, Integer endDate) {
        QueryWrapper<ReportEffect> queryWrapper = new QueryWrapper<>();
        if (cityId != null) {
            queryWrapper.eq("city_id", cityId);
        }
        queryWrapper.between("date", startDate, endDate);
        return this.list(queryWrapper);
    }

    public Double formatDouble(String str) {
        String[] split = str.split("%");
        return Double.valueOf(split[0]) / 100;
    }
}
