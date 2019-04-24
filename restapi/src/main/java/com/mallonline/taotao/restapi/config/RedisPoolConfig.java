package com.mallonline.taotao.restapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisPoolConfig {

    @Value("${redis.HOST}")
    private String Host;

    @Bean(name = "JedisPool")
    public JedisPool jedisPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(5000);
        config.setMaxIdle(50);
        config.setMaxWaitMillis(5000);
        return new JedisPool(config,this.Host);
    }
}
