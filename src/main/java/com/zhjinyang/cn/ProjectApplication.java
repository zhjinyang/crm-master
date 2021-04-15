package com.zhjinyang.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Zjy
 * @date 2021/4/14 21:24
 */
@SpringBootApplication
@MapperScan(basePackages = "com.zhjinyang.cn.mapper")
@EnableTransactionManagement
public class ProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);

    }
}
