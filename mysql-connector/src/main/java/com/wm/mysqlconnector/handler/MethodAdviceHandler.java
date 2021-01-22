package com.wm.mysqlconnector.handler;

import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

/**
 * @author wm
 * @Package com.wm.mysqlconnector.handler
 * @date 2021/1/22 17:29
 */
public interface MethodAdviceHandler<R> {
    /*
    * 目标方法执行前的判断，判断目标方法是否允许执行。默认返回true,即默认允许执行
    * @param point 目标方法的连接点
    * @return 返回true则表示允许调用目标方法；放回false则表示禁止调用目标方法
    * 当返回false时，此时会先调用getOnForbid方法获得被禁止执行时的返回值，然后
    * 调用onComplete方法结束切面
    * */
    default boolean onBefore(MethodInvocationProceedingJoinPoint point) {
        return true;
    }

    /**
     * 禁止调用目标方法时（即 onBefore 返回 false），执行该方法获得返回值，默认返回 null
     *
     * @param point 目标方法的连接点
     * @return 禁止调用目标方法时的返回值
     */
    default R getOnForbid(MethodInvocationProceedingJoinPoint point) { return null; }

    /**
     * 目标方法抛出异常时，执行的动作
     *
     * @param point 目标方法的连接点
     * @param e     抛出的异常
     */
    void onThrow(MethodInvocationProceedingJoinPoint point, Throwable e);

    /**
     * 获得抛出异常时的返回值，默认返回 null
     *
     * @param point 目标方法的连接点
     * @param e     抛出的异常
     * @return 抛出异常时的返回值
     */
    default R getOnThrow(MethodInvocationProceedingJoinPoint point, Throwable e) { return null; }

    /**
     * 目标方法完成时，执行的动作
     *
     * @param point     目标方法的连接点
     * @param startTime 执行的开始时间
     * @param permitted 目标方法是否被允许执行
     * @param thrown    目标方法执行时是否抛出异常
     * @param result    执行获得的结果
     */
    default void onComplete(MethodInvocationProceedingJoinPoint point, long startTime, boolean permitted, boolean thrown, Object result) { }

}
