package com.mallonline.taotao.restapi.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Bean(name="taotaoDataSource")
    @Qualifier("taotaoDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource taotaoDataSource(){
        return new DruidDataSource();
    }
}
