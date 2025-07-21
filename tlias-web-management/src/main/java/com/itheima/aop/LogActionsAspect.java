package com.itheima.aop;

import com.itheima.anno.LogOperation;
import com.itheima.mapper.OperateLogMapper;
import com.itheima.pojo.OperateLog;
import com.itheima.utils.CurrentHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class LogActionsAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogActionsAspect.class);
    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.itheima.anno.LogOperation)")
    public Object logOperation(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("开始执行操作：{}", methodName);
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed(); //执行原方法
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;
        logger.info("操作完成: {} | 耗时: {}ms", methodName, endTime-startTime);

        //构建日志
        OperateLog log = new OperateLog();
        log.setOperateEmpId(getCurrentUserId());
        log.setOperateTime(LocalDateTime.now());
        log.setClassName(joinPoint.getClass().getName());
        log.setMethodName(joinPoint.getSignature().getName());
        log.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        log.setCostTime(costTime);
        logger.info("记录日志操作：{}", log);
        operateLogMapper.insert(log);

        return result;
    }

    private Integer getCurrentUserId() {
        return CurrentHolder.getCurrentId();
    }
}
