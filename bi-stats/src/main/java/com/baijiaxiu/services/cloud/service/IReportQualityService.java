package com.baijiaxiu.services.cloud.service;


import com.baijiaxiu.services.cloud.entity.bi.ReportQuality;
import com.baijiaxiu.services.cloud.vo.ReportQualityVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 品质报表 服务类
 * </p>
 *
 * @author liuyufeng
 * @since 2019-09-02
 */
public interface IReportQualityService extends IService<ReportQuality> {
    /**
     * 根据条件查询品质报表
     *
     * @param cityId
     * @param startDate
     * @param endDate
     * @return
     */
    List<ReportQualityVO> listQualitys(Integer cityId, Integer startDate, Integer endDate);
}
