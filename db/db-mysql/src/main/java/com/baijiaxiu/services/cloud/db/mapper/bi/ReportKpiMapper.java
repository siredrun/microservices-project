package com.baijiaxiu.services.cloud.db.mapper.bi;


import com.baijiaxiu.services.cloud.entity.bi.ReportKpi;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>
 * kpi报表 Mapper 接口
 * </p>
 *
 * @author liuyufeng
 * @since 2019-08-29
 */
@Mapper
@Component
public interface ReportKpiMapper extends BaseMapper<ReportKpi> {

    /**
     * 获取人效超标率分子
     *
     * @param cityId
     * @param startDate
     * @param endDate
     * @param timeDIff
     * @return
     */
    Double getHumanEffectRateNumerator(@Param("cityId") Integer cityId, @Param("startDate") String startDate, @Param("endDate") String endDate, @Param("timeDIff") Integer timeDIff);

    /**
     * 获取人效超标率分母
     *
     * @param cityId
     * @param startDate
     * @param endDate
     * @return
     */
    Double getHumanEffectRateDenominator(@Param("cityId") Integer cityId, @Param("startDate") String startDate, @Param("endDate") String endDate);
}
