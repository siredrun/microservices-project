package com.baijiaxiu.services.cloud.db.mapper.bi;


import com.baijiaxiu.services.cloud.entity.bi.ReportCost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 成本报表 Mapper 接口
 * </p>
 *
 * @author liuyufeng
 * @since 2019-09-03
 */
@Mapper
@Component
public interface ReportCostMapper extends BaseMapper<ReportCost> {

}
