package com.clover.springtransactiondemo;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTransactionDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTransactionDemoApplication.class, args);
    }

}
