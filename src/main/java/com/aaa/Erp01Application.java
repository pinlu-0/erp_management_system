package com.aaa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.aaa.dao")
public class Erp01Application {

    public static void main(String[] args) {
        SpringApplication.run(Erp01Application.class, args);
    }

}
