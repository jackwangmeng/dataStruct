package com.wm.mysqlconnector.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

/**
 * @author wm
 * @Package com.wm.mysqlconnector.handler
 * @date 2021/1/22 17:35
 */
public abstract class BaseMethodAdviceHandler<R> implements MethodAdviceHandler<R> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    

}
