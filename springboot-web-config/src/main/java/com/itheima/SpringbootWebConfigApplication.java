package com.itheima;

import com.example.EnableHeaderConfig;
import com.example.TokenParser;
import com.itheima.utils.AliyunOSSOperator;
import com.itheima.utils.AliyunOSSProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@EnableHeaderConfig
//@Import(TokenParser.class)
@SpringBootApplication
public class SpringbootWebConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebConfigApplication.class, args);
    }

    //加上@Bean注解后，若该方法和目标类同名，则该项目启动时会自动调用该方法，并且会将该方法的返回值自动交给IOC容器管理（成为IOC容器的bean对象）
    @Bean
    public AliyunOSSOperator aliyunOSSOperator(@Autowired AliyunOSSProperties aliyunOSSProperties) { //方法运行时，容器会自动从IOC容器中找到AliyunOSSProperties的Bean对象
        return new AliyunOSSOperator(aliyunOSSProperties);
    }
}
