package com.baijiaxiu.services.cloud.service;


import com.baijiaxiu.services.cloud.entity.bi.ReportOrderType;
import com.baijiaxiu.services.cloud.vo.ReportOrderTypeVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 工单类型报表 服务类
 * </p>
 *
 * @author liuyufeng
 * @since 2019-09-03
 */
public interface IReportOrderTypeService extends IService<ReportOrderType> {
    /**
     * 根据条件查询工单类型报表
     *
     * @param cityId
     * @param startDate
     * @param endDate
     * @return
     */
    List<ReportOrderTypeVO> listOrderTypes(Integer cityId, Integer startDate, Integer endDate);
}
