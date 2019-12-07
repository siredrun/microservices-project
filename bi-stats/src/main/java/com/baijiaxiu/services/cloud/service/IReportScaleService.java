package com.baijiaxiu.services.cloud.service;


import com.baijiaxiu.services.cloud.entity.bi.ReportScale;
import com.baijiaxiu.services.cloud.vo.ReportScaleVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 规模报表 服务类
 * </p>
 *
 * @author liuyufeng
 * @since 2019-09-02
 */
public interface IReportScaleService extends IService<ReportScale> {

    /**
     * 根据条件查询kpi报表
     *
     * @param cityId
     * @param startDate
     * @param endDate
     * @return
     */
    List<ReportScaleVO> listScales(Integer cityId, Integer startDate, Integer endDate);
}
