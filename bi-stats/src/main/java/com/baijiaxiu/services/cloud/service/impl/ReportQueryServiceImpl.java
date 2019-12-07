package com.baijiaxiu.services.cloud.service.impl;

import com.baijiaxiu.services.cloud.enums.ReportTypeEnum;
import com.baijiaxiu.services.cloud.dto.ReportQueryDTO;
import com.baijiaxiu.services.cloud.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 报表查询
 * @author: liuyufeng
 * @date: 2019-08-30 15:23
 */
@Service
public class ReportQueryServiceImpl implements IReportQueryService {

    @Autowired
    private IReportKpiService iReportKpiService;

    @Autowired
    private IReportScaleService iReportScaleService;

    @Autowired
    private IReportCostService iReportCostService;

    @Autowired
    private IReportQualityService iReportQualityService;

    @Autowired
    private IReportOrderTypeService iReportOrderTypeService;

    @Autowired
    private IReportEffectService iReportEffectService;

    @Override
    public List<?> listReports(ReportQueryDTO reportQueryDTO) {
        List<?> data = null;
        // 根据type查询不同的报表
        ReportTypeEnum anEnum = ReportTypeEnum.getEnum(reportQueryDTO.getType());
        switch (anEnum) {
            case ORDER_TYPE:
                data = iReportOrderTypeService.listOrderTypes(reportQueryDTO.getCityId(), reportQueryDTO.getStartDate(), reportQueryDTO.getEndDate());
                break;
            case QUALITY:
                data = iReportQualityService.listQualitys(reportQueryDTO.getCityId(), reportQueryDTO.getStartDate(), reportQueryDTO.getEndDate());
                break;
            case AGING:
                data = iReportEffectService.listEffects(reportQueryDTO.getCityId(), reportQueryDTO.getStartDate(), reportQueryDTO.getEndDate());
                break;
            case COST:
                data = iReportCostService.listCosts(reportQueryDTO.getCityId(), reportQueryDTO.getStartDate(), reportQueryDTO.getEndDate());
                break;
            case SCALE:
                data = iReportScaleService.listScales(reportQueryDTO.getCityId(), reportQueryDTO.getStartDate(), reportQueryDTO.getEndDate());
                break;
            case KPI:
                data = iReportKpiService.listKpis(reportQueryDTO.getCityId(), reportQueryDTO.getStartDate(), reportQueryDTO.getEndDate());
                break;
            default:
                break;
        }
        return data;
    }
}
