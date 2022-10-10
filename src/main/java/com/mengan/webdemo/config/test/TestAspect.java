package com.mengan.webdemo.config.test;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Author: zhanmingwei
 */
@Aspect
@Component
@Slf4j
public class TestAspect {
    @Around("execution (* org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor.*(..))")
    public Object traceThreadPoolTaskExecutor(final ProceedingJoinPoint pjp) throws Throwable {
        log.info("hello~1111111111111111111");
        return pjp.proceed();
    }


//    @Around("execution (* com.mengan.webdemo.service.user.UserService.*(..))")
//    public Object test(final ProceedingJoinPoint pjp) throws Throwable {
//    log.info("hello~1111111111111111111");
//    return pjp.proceed();
//}
}
