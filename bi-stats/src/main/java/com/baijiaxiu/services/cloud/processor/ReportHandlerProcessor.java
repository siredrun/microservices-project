package com.baijiaxiu.services.cloud.processor;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @description:
 * @author: liuyufeng
 * @date: 2019-09-21 17:02
 */
@Component
public class ReportHandlerProcessor implements BeanFactoryPostProcessor {

    private static final String HANDLER_PACKAGE = "com.baijiaxiu.services.cloud.processor.handler.impl";


    /**
     * 扫描 @ReportHandlerType,初始化HandlerContext,将其注册到spring容器中
     *
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        HashMap<Object, Object> handlerMap = Maps.newHashMapWithExpectedSize(6);
    }
}
