package com.baijiaxiu.services.cloud.db.mapper.bi;


import com.baijiaxiu.services.cloud.entity.bi.OrderAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 工单结算表 Mapper 接口
 * </p>
 *
 * @author liuyufeng
 * @since 2019-08-27
 */
@Mapper
@Component
public interface OrderAccountMapper extends BaseMapper<OrderAccount> {

}
