package com.lihewei.configer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class Redisconfig {

    @Bean
    public RedisTemplate<String,String> redisTemplate(){
        return  new RedisTemplate<String, String> ();
    }
}
