package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliyunOSSOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
    // 本地磁盘存储
//    private static final Logger log = LoggerFactory.getLogger(EmpController.class);
//    private static final String UPLOAD_DIR = "C:/Users/Y/Pictures/Camera Roll";
//
//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    public Result upload(MultipartFile file) throws IOException {
//        log.info("上传文件：{}", file);
//        if(!file.isEmpty()){
//            //获取原始文件名
//            String originalFilename = file.getOriginalFilename();
//            //随机生成唯一的新文件名
//            String extension = originalFilename.substring(originalFilename.lastIndexOf(".")); //获取原文件后缀
//            String newFilename = UUID.randomUUID().toString() + extension;
//            //将文件保存到指定位置
//            File targetFile = new File(UPLOAD_DIR + file.getOriginalFilename());
//            if (!targetFile.getParentFile().exists()) {
//                targetFile.getParentFile().mkdirs(); //如果目标路径路径不存在，创建
//            }
//            file.transferTo(targetFile);
//        }
//        return Result.success();
//    }

    //阿里云托管
    private static final Logger log = LoggerFactory.getLogger(UploadController.class);

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result upload(MultipartFile file) throws Exception {
        log.info("文件上传：{}", file.getOriginalFilename());
        //将文件交给阿里云oss托管存储管理
        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        log.info("文件上传至OSS：{}", url);

        return Result.success(url);
    }
}
