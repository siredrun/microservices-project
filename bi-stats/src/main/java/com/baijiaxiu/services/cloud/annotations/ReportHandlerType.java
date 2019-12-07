package com.baijiaxiu.services.cloud.annotations;

import java.lang.annotation.*;

/**
 * @description: 用于标识该处理器对应的报表类型
 * @author: liuyufeng
 * @date: 2019-09-21 16:57
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ReportHandlerType {
    String value();
}
