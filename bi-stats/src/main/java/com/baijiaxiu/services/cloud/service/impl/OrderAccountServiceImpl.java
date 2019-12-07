package com.baijiaxiu.services.cloud.service.impl;

import com.baijiaxiu.services.cloud.db.mapper.bi.OrderAccountMapper;
import com.baijiaxiu.services.cloud.entity.bi.OrderAccount;
import com.baijiaxiu.services.cloud.service.IOrderAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 工单结算表 服务实现类
 * </p>
 *
 * @author liuyufeng
 * @since 2019-08-27
 */
@Service
public class OrderAccountServiceImpl extends ServiceImpl<OrderAccountMapper, OrderAccount> implements IOrderAccountService {

}
