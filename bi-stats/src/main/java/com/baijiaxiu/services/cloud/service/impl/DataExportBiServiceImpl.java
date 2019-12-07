package com.baijiaxiu.services.cloud.service.impl;

import com.baijiaxiu.services.cloud.db.mapper.bi.DataExportBiMapper;
import com.baijiaxiu.services.cloud.dto.DataQueryDTO;
import com.baijiaxiu.services.cloud.entity.bi.DataExportBi;
import com.baijiaxiu.services.cloud.entity.bi.DataExportBiLong;
import com.baijiaxiu.services.cloud.service.IDataExportBiLongService;
import com.baijiaxiu.services.cloud.service.IDataExportBiService;
import com.baijiaxiu.services.cloud.vo.DataExportBiVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liuyufeng
 * @since 2019-10-11
 */
@Service
public class DataExportBiServiceImpl extends ServiceImpl<DataExportBiMapper, DataExportBi> implements IDataExportBiService {

    @Autowired
    private IDataExportBiLongService iDataExportBiLongService;

    @Override
    public List<DataExportBiVO> listOrderData(DataQueryDTO dataQueryDTO, Integer type) {
        // 默认创建时间排序
        String orderByStr = "create_time";
        QueryWrapper<DataExportBi> queryWrapper = new QueryWrapper<>();
        // 转派时间
        if (StringUtils.isNotEmpty(dataQueryDTO.getAllocationStartTime()) && StringUtils.isNotEmpty(dataQueryDTO.getAllocationEndTime())) {
            queryWrapper.between("allocation_time", dataQueryDTO.getAllocationStartTime(), dataQueryDTO.getAllocationEndTime());
            orderByStr = "allocation_time";
        }
        // 创建时间
        if (StringUtils.isNotEmpty(dataQueryDTO.getCreateStartDate()) && StringUtils.isNotEmpty(dataQueryDTO.getCreateEndDate())) {
            queryWrapper.between("create_time", dataQueryDTO.getCreateStartDate(), dataQueryDTO.getCreateEndDate());
        }

        // 完成时间
        if (StringUtils.isNotEmpty(dataQueryDTO.getFinishStartTime()) && StringUtils.isNotEmpty(dataQueryDTO.getFinishEndTime())) {
            queryWrapper.between("practical_finish_time", dataQueryDTO.getFinishStartTime(), dataQueryDTO.getFinishEndTime());
            orderByStr = "practical_finish_time";
        }
        // 城市
        if (StringUtils.isNotEmpty(dataQueryDTO.getCityName())) {
            queryWrapper.eq("city", dataQueryDTO.getCityName());
        }
        // 师傅Id
        if (StringUtils.isNotEmpty(dataQueryDTO.getWorkerId())) {
            queryWrapper.eq("worker_id", dataQueryDTO.getWorkerId());
        }
        queryWrapper.orderByAsc(orderByStr);
        if (type.equals(1)) {
            queryWrapper.last("limit 10");
        }
        List<DataExportBi> list = this.list(queryWrapper);
        List<DataExportBiVO> biVOS = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(list)) {
            biVOS = list.stream().parallel().map(o -> {
                DataExportBiVO biVO = new DataExportBiVO();
                BeanUtils.copyProperties(o, biVO);
                DataExportBiLong byId = iDataExportBiLongService.getById(o.getOutOrderNo());
                if (byId != null) {
                    BeanUtils.copyProperties(byId, biVO);
                }
                return biVO;
            }).collect(Collectors.toList());
        }
        return biVOS;
    }
}
