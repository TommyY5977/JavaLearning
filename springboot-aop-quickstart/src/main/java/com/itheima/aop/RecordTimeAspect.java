package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Aspect //标识当前是一个AOP类
@Component
public class RecordTimeAspect {
    private static final Logger log = LoggerFactory.getLogger(RecordTimeAspect.class);

    @Around("execution(* com.itheima.service.impl.*.*(..))")
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
        //1. 记录方法运行的时间
        long begin = System.currentTimeMillis();

        //2. 执行原始的方法
        Object result = pjp.proceed();

        //3. 记录方法运行的结束时间，记录耗时
        long end = System.currentTimeMillis();
        log.info("方法{}执行耗时：{}ms", pjp.getSignature(), end-begin);
        return result;
    }
}
