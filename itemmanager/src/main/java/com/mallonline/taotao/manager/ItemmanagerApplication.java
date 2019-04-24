package com.mallonline.taotao.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.mallonline.taotao.manager.mapper"})
public class ItemmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemmanagerApplication.class, args);
    }

}
