package com.mallonline.taotao.restapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.mallonline.taotao.restapi.mapper"})
//@ComponentScan(basePackages = {"com.mallonline.taotao.restapi.jedis",
//        "com.mallonline.taotao.restapi.config"})
public class RestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
    }

}
