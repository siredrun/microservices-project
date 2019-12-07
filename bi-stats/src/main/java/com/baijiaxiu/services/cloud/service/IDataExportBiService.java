package com.baijiaxiu.services.cloud.service;

import com.baijiaxiu.services.cloud.dto.DataQueryDTO;
import com.baijiaxiu.services.cloud.entity.bi.DataExportBi;
import com.baijiaxiu.services.cloud.vo.DataExportBiVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liuyufeng
 * @since 2019-10-11
 */
public interface IDataExportBiService extends IService<DataExportBi> {

    /**
     * 订单导出查询
     *
     * @param dataQueryDTO 查询条件
     * @param type         类型 1-查询 2-导出
     * @return
     */
    List<DataExportBiVO> listOrderData(DataQueryDTO dataQueryDTO, Integer type);
}
