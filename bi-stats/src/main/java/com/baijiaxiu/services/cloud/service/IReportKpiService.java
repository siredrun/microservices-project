package com.baijiaxiu.services.cloud.service;


import com.baijiaxiu.services.cloud.entity.bi.ReportKpi;
import com.baijiaxiu.services.cloud.vo.ReportKpiVO;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * kpi报表 服务类
 * </p>
 *
 * @author liuyufeng
 * @since 2019-08-29
 */
public interface IReportKpiService extends IService<ReportKpi> {
    /**
     * 根据条件查询kpi报表
     *
     * @param cityId
     * @param startDate
     * @param endDate
     * @return
     */
    List<ReportKpiVO> listKpis(Integer cityId, Integer startDate, Integer endDate);


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





