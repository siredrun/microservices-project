package com.baijiaxiu.services.cloud.controller;


import com.alibaba.fastjson.JSONObject;
import com.baijiaxiu.services.cloud.common.result.ResponseInfoBaseEnum;
import com.baijiaxiu.services.cloud.common.result.ResultBody;
import com.baijiaxiu.services.cloud.common.utils.ExcelUtils;
import com.baijiaxiu.services.cloud.dto.DataQueryDTO;
import com.baijiaxiu.services.cloud.entity.bi.DataExportBi;
import com.baijiaxiu.services.cloud.service.IDataExportBiService;
import com.baijiaxiu.services.cloud.vo.DataExportBiVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liuyufeng
 * @since 2019-10-11
 */
@RestController
@RequestMapping("/data-export-bi")
@Api(tags = "订单导出")
@Slf4j
public class DataExportBiController {


    @Autowired
    private IDataExportBiService iDataExportBiService;

    @PostMapping(value = "findDataList")
    @ApiOperation(value = "查询导出订单数据")
    @ApiResponses(@ApiResponse(code = 200, message = "成功", response = DataExportBi.class))
    public String findDataList(@RequestBody DataQueryDTO dataQueryDTO) {
        String method = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("{} 请求参数 {}", method, JSONObject.toJSONString(dataQueryDTO));
        List<DataExportBiVO> dataExportBis = iDataExportBiService.listOrderData(dataQueryDTO, 1);
        if (CollectionUtils.isEmpty(dataExportBis)) {
            return ResultBody.error(ResponseInfoBaseEnum.NO_DATA);
        } else {
            return ResultBody.success(dataExportBis);
        }
    }


    @GetMapping(value = "exportData")
    @ApiOperation(value = "导出订单数据")
    public String exportData(@RequestParam(required = false) String workerId,
                             @RequestParam(required = false) String cityName,
                             @RequestParam(required = false) String createStartDate,
                             @RequestParam(required = false) String createEndDate,
                             @RequestParam(required = false) String allocationStartTime,
                             @RequestParam(required = false) String allocationEndTime,
                             @RequestParam(required = false) String finishStartTime,
                             @RequestParam(required = false) String finishEndTime,
                             HttpServletResponse response) {
        DataQueryDTO dataQueryDTO = new DataQueryDTO();
        dataQueryDTO.setWorkerId(workerId);
        dataQueryDTO.setCityName(cityName);
        dataQueryDTO.setCreateStartDate(createStartDate);
        dataQueryDTO.setCreateEndDate(createEndDate);
        dataQueryDTO.setAllocationStartTime(allocationStartTime);
        dataQueryDTO.setAllocationEndTime(allocationEndTime);
        dataQueryDTO.setFinishStartTime(finishStartTime);
        dataQueryDTO.setFinishEndTime(finishEndTime);
        String method = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("{} 请求参数 {}", method, JSONObject.toJSONString(dataQueryDTO));
        List<DataExportBiVO> dataExportBis = iDataExportBiService.listOrderData(dataQueryDTO, 2);
        if (CollectionUtils.isNotEmpty(dataExportBis)) {
            // 下载文件
            ExcelUtils.download(response, DataExportBiVO.class, dataExportBis, "订单导出");
            return ResultBody.success();
        } else {
            return ResultBody.error(ResponseInfoBaseEnum.NO_DATA);
        }

    }
}

