package com.baijiaxiu.services.cloud.service;

import com.baijiaxiu.services.cloud.entity.bi.ReportEffect;
import com.baijiaxiu.services.cloud.vo.ReportEffectVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 时效报表 服务类
 * </p>
 *
 * @author liuyufeng
 * @since 2019-09-04
 */
public interface IReportEffectService extends IService<ReportEffect> {
    /**
     * 根据条件查询时效报表
     *
     * @param cityId
     * @param startDate
     * @param endDate
     * @return
     */
    List<ReportEffectVO> listEffects(Integer cityId, Integer startDate, Integer endDate);
}
