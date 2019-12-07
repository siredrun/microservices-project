package com.baijiaxiu.services.cloud.common.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @description: rabbitmq 配置信息
 * @author: liuyufeng
 * @date: 2019-10-10 15:31
 */
@Component
@Getter
public class SysProperties {


    /**
     * 验签开关
     */
    @Value(value = "${com.baijixiu.sign_switch}")
    public Boolean signSwitch;

    /**
     * secret_id
     */
    @Value(value = "${com.baijixiu.secret_id}")
    public String secretId;

    /**
     * secret_key
     */
    @Value(value = "${com.baijixiu.secret_key}")
    public String secretKey;

}
