package com.baijiaxiu.services.cloud.controller;


import com.baijiaxiu.services.cloud.common.result.ResponseInfoBaseEnum;
import com.baijiaxiu.services.cloud.common.result.ResultBody;
import com.baijiaxiu.services.cloud.common.utils.ExcelUtils;
import com.baijiaxiu.services.cloud.dto.ReportQueryDTO;
import com.baijiaxiu.services.cloud.enums.ReportTypeEnum;
import com.baijiaxiu.services.cloud.service.IReportQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 报表 前端控制器
 * </p>
 *
 * @author liuyufeng
 * @since 2019-08-27
 */
@RestController
@RequestMapping("/report-export")
@Api(tags = "导出报表数据")
public class ReportExportController {

    @Autowired
    private IReportQueryService iReportQueryService;

    @GetMapping(value = "exportReport")
    @ApiOperation(value = "导出报表数据")
    public String exportReport(@RequestParam(required = false) Integer cityId,
                               @RequestParam(required = false) Integer startDate,
                               @RequestParam(required = false) Integer endDate,
                               @RequestParam(required = false) Integer type, HttpServletResponse response) {
        ReportQueryDTO reportQueryDTO = new ReportQueryDTO();
        reportQueryDTO.setCityId(cityId);
        reportQueryDTO.setStartDate(startDate);
        reportQueryDTO.setEndDate(endDate);
        reportQueryDTO.setType(type);
        List<?> data = iReportQueryService.listReports(reportQueryDTO);
        if (data != null && data.size() > 0) {
            ReportTypeEnum anEnum = ReportTypeEnum.getEnum(type);
            // 下载文件
            ExcelUtils.download(response, anEnum.getMappingClass(), data, anEnum.getMessage());
            return ResultBody.success();
        } else {
            return ResultBody.error(ResponseInfoBaseEnum.NO_DATA);
        }

    }
}

