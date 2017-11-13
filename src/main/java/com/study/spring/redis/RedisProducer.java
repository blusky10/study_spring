package com.study.spring.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by blusky10 on 2017. 11. 13..
 */
@Component
public class RedisProducer {

    private static final Logger logger = LoggerFactory.getLogger(RedisProducer.class);

    private StringRedisTemplate template;

    @Autowired
    public RedisProducer(StringRedisTemplate template){
        this.template = template;
    }

    public void sendTo(String redisTopic, String value){
        logger.info("전송>>>>>>");
        this.template.convertAndSend(redisTopic, value);
    }
}
