//package com.study.spring.redis.config;
//
//import com.study.spring.redis.RedisConsumer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.listener.PatternTopic;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
//
///**
// * Created by blusky10 on 2017. 11. 13..
// */
//@Configuration
//public class RedisConfig {
//
//    @Value("${redisTopic}")
//    String redisTopic;
//
//    @Bean
//    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter){
//        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.addMessageListener(listenerAdapter, new PatternTopic(redisTopic));
//        return container;
//    }
//
//    @Bean
//    MessageListenerAdapter listenerAdapter(RedisConsumer consumer){
//        return new MessageListenerAdapter(consumer, "messageHandler");
//    }
//}
