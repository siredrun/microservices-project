package com.baijiaxiu.services.cloud.controller;

import com.alibaba.excel.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baijiaxiu.services.cloud.common.properties.SysProperties;
import com.baijiaxiu.services.cloud.common.result.ResponseInfoBaseEnum;
import com.baijiaxiu.services.cloud.common.result.ResultBody;
import com.baijiaxiu.services.cloud.common.utils.SignUtil;
import com.baijiaxiu.services.cloud.dto.WorkerPerformanceDTO;
import com.baijiaxiu.services.cloud.service.ICollegeWorkerPerformanceService;
import com.baijiaxiu.services.cloud.vo.WorkerPerformanceVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liuyufeng
 * @since 2019-11-11
 */
@Slf4j
@RestController
@RequestMapping("/worker-performance")
@Api(tags = "师傅绩效查询")
public class WorkerPerformanceController {
    @Autowired
    private ICollegeWorkerPerformanceService collegeWorkerPerformanceService;

    @Autowired
    SysProperties sysProperties;

    @PostMapping(value = "getWorkerPerformanceVO")
    @ApiOperation(value = "查询导出师傅绩效数据")
    @ApiResponses(@ApiResponse(code = 200, message = "成功", response = WorkerPerformanceVO.class))
    public String getWorkerPerformanceVO(@RequestBody WorkerPerformanceDTO workerPerformanceDTO) {
        String method = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("{} 请求参数 {}", method, JSONObject.toJSONString(workerPerformanceDTO));
        if (workerPerformanceDTO == null) {
            log.error("没有参数");
            return ResultBody.error("没有参数");
        }
        // 校验验签
        if (sysProperties.signSwitch) {
            String sign = workerPerformanceDTO.getSign();
            if (StringUtils.isEmpty(sign)) {
                log.error("缺少验签");
                return ResultBody.error("缺少验签");
            }
            String sysSign = SignUtil.getSign(workerPerformanceDTO, sysProperties.secretId, sysProperties.secretKey);
            if (!sysSign.equals(sign)) {
                log.error("验签错误");
                return ResultBody.error("验签错误");
            }
        }
        if (StringUtils.isEmpty(workerPerformanceDTO.getWorkerId().toString())) {
            log.error("师傅Id不能为空");
            return ResultBody.error("师傅Id不能为空");
        }
        if (workerPerformanceDTO.getStartDate() == null) {
            log.error("开始时间不能为空");
            return ResultBody.error("开始时间不能为空");
        }
        if (workerPerformanceDTO.getEndDate() == null) {
            log.error("结束时间不能为空");
            return ResultBody.error("结束时间不能为空");
        }
        WorkerPerformanceVO data = collegeWorkerPerformanceService.getWorkerPerformanceVO(workerPerformanceDTO);
        if (data == null) {
            log.error("获取不到数据:{}", data);
            return ResultBody.error(ResponseInfoBaseEnum.NO_DATA);
        } else {
            return ResultBody.success(data);
        }
    }

    public static void main(String[] args) {
        WorkerPerformanceDTO workerPerformanceDTO = new WorkerPerformanceDTO();
        workerPerformanceDTO.setWorkerId(34);
        workerPerformanceDTO.setStartDate("20190711");
        workerPerformanceDTO.setEndDate("20190714");
        String sysSign = SignUtil.getSign(workerPerformanceDTO, "jqajUZ78EiiNFK0a", "JPcehJ8gyacaq3MM");
        workerPerformanceDTO.setSign(sysSign);
        System.out.println(sysSign);
        System.out.println(JSON.toJSONString(workerPerformanceDTO));
    }
}

