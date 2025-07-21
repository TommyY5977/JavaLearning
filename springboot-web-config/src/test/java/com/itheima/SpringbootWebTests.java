package com.itheima;

import com.example.TokenParser;
import cn.hutool.core.io.FileUtil;
import com.itheima.utils.AliyunOSSOperator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class SpringbootWebTests {
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;
    @Autowired
    private TokenParser tokenParser;

    @Test
    public void testUpload() throws Exception {
        File file = new File("C:\\Users\\Y\\Pictures\\QQ图片20250622173354.jpg");
        String url = aliyunOSSOperator.upload(FileUtil.readBytes(file), "QQ图片20250622173354.jpg");
        System.out.println(url);
    }

    @Test
    public void testTokenParser() {
        tokenParser.parse();
    }
}
