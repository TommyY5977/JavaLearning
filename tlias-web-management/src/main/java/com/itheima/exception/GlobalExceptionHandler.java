package com.itheima.exception;

/*
* 全局异常处理器*/

import com.itheima.controller.EmpController;
import com.itheima.pojo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(EmpController.class);

    @ExceptionHandler
    public Result handleException(Exception e) {
        log.error("程序出错了！！！", e);
        return Result.error("出错啦，请联系管理员~~");
    }

    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        log.error("程序出错了！！！", e);
        String message = e.getMessage();
        int i = message.indexOf("Duplicate entry");
        String errMsg = message.substring(i);
        String[] arr = errMsg.split(" ");
        return Result.error(arr[2] + "已存在");
    }

    @ExceptionHandler
    public Result handleClazzHasStudentsException(Exception e) {
        log.error("有关联同学，无法删除", e);
        return Result.error(e.getMessage());
    }
}
