package com.baijiaxiu.services.cloud;

import com.alibaba.fastjson.JSON;
import com.baijiaxiu.services.cloud.common.utils.SignUtil;
import com.baijiaxiu.services.cloud.controller.WorkerPerformanceController;
import com.baijiaxiu.services.cloud.dto.WorkerPerformanceDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: chenxingxing
 * @date: 2019/11/11 16:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BiApplication.class)
public class WorkerPerformanceTest {

    @Autowired
    private WorkerPerformanceController controller;

    @Test
    public void testFindWorkerPerformanceList() {
        WorkerPerformanceDTO workerPerformanceDTO = new WorkerPerformanceDTO();
        workerPerformanceDTO.setWorkerId(34);
        workerPerformanceDTO.setStartDate("2019-07-11");
        workerPerformanceDTO.setEndDate("2019-07-14");
        System.out.println();
        String sysSign = SignUtil.getSign(workerPerformanceDTO, "jqajUZ78EiiNFK0a", "JPcehJ8gyacaq3MM");
        workerPerformanceDTO.setSign(sysSign);
        System.out.println(JSON.toJSONString(workerPerformanceDTO));
        String vo = controller.getWorkerPerformanceVO(workerPerformanceDTO);
        System.out.println(vo);
    }
}
