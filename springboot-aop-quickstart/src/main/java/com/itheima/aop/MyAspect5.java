package com.itheima.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Aspect
public class MyAspect5 {
    private static final Logger log = LoggerFactory.getLogger(MyAspect5.class);

    @Before("execution(* com.itheima.service.impl.DeptServiceImpl.list(..)) ||" +
            "execution(* com.itheima.service.impl.DeptServiceImpl.delete(..))")
    public void before() {
        log.info("MyAspect5 -> before ...");
    }
}
