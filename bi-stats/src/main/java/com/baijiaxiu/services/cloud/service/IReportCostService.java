package com.baijiaxiu.services.cloud.service;


import com.baijiaxiu.services.cloud.entity.bi.ReportCost;
import com.baijiaxiu.services.cloud.vo.ReportCostVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 成本报表 服务类
 * </p>
 *
 * @author liuyufeng
 * @since 2019-09-03
 */
public interface IReportCostService extends IService<ReportCost> {
    /**
     * 根据条件查询成本报表
     *
     * @param cityId
     * @param startDate
     * @param endDate
     * @return
     */
    List<ReportCostVO> listCosts(Integer cityId, Integer startDate, Integer endDate);
}
