package com.baijiaxiu.services.cloud.controller;


import com.alibaba.fastjson.JSONObject;
import com.baijiaxiu.services.cloud.common.result.ResponseInfoBaseEnum;
import com.baijiaxiu.services.cloud.common.result.ResultBody;
import com.baijiaxiu.services.cloud.dto.ReportQueryDTO;
import com.baijiaxiu.services.cloud.service.IReportQueryService;
import com.baijiaxiu.services.cloud.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
@RequestMapping("/report-query")
@Api(tags = "报表查询")
@Slf4j
public class ReportQueryController {

    @Autowired
    private IReportQueryService iReportQueryService;

    @PostMapping(value = "findReportList")
    @ApiOperation(value = "查询报表数据")
    @ApiResponses({@ApiResponse(code = 200, message = "成功", response = ReportKpiVO.class)
            , @ApiResponse(code = 200, message = "成功", response = ReportScaleVO.class)
            , @ApiResponse(code = 200, message = "成功", response = ReportCostVO.class)
            , @ApiResponse(code = 200, message = "成功", response = ReportQualityVO.class)
            , @ApiResponse(code = 200, message = "成功", response = ReportOrderTypeVO.class)
            , @ApiResponse(code = 200, message = "成功", response = ReportEffectVO.class)})
    public String findReportList(@RequestBody @Valid ReportQueryDTO reportQueryDTO, BindingResult bindingResult) {
        String method = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("{} 请求参数 {}", method, JSONObject.toJSONString(reportQueryDTO));
        if (bindingResult.hasErrors()) {
            return ResultBody.error(bindingResult.getFieldError().getDefaultMessage());
        }
        // 根据type查询不同的报表
        List<?> data = iReportQueryService.listReports(reportQueryDTO);
        if (data == null || data.size() == 0) {
            return ResultBody.error(ResponseInfoBaseEnum.NO_DATA);
        } else {
            return ResultBody.success(data);
        }
    }
}

