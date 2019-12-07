package com.baijiaxiu.services.cloud.service;

import com.baijiaxiu.services.cloud.dto.WorkerPerformanceDTO;
import com.baijiaxiu.services.cloud.entity.bi.CollegeWorkerPerformance;
import com.baijiaxiu.services.cloud.vo.WorkerPerformanceVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liuyufeng
 * @since 2019-11-28
 */
public interface ICollegeWorkerPerformanceService extends IService<CollegeWorkerPerformance> {

    /**
     * 根据师傅Id以及起始-结束时间查询师傅绩效
     *
     * @param workerPerformerceDTO
     * @return
     */
    WorkerPerformanceVO getWorkerPerformanceVO(WorkerPerformanceDTO workerPerformerceDTO);
}
