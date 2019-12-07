package com.baijiaxiu.services.cloud.service;

import com.baijiaxiu.services.cloud.dto.ReportQueryDTO;

import java.util.List;

/**
 * @description: 报表查询
 * @author: liuyufeng
 * @date: 2019-08-30 15:23
 */
public interface IReportQueryService {

    /**
     * 根据查询条件查询报表
     *
     * @param reportQueryDTO
     * @return
     */
    List<?> listReports(ReportQueryDTO reportQueryDTO);
}
