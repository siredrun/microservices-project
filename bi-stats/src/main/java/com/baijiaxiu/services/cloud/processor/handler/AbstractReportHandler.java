package com.baijiaxiu.services.cloud.processor.handler;

import com.baijiaxiu.services.cloud.dto.ReportQueryDTO;

import java.util.List;

/**
 * @description: 报表抽象处理器
 * @author: liuyufeng
 * @date: 2019-09-21 16:41
 */
public abstract class AbstractReportHandler {
    abstract public List<?> handle(ReportQueryDTO reportQueryDTO);
}
