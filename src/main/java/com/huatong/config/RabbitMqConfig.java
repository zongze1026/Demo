package com.huatong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Queue;

@Configuration
public class RabbitMqConfig {

    private static final String queueName = "test";

    @Bean
    public Queue<String> getQueue() {
        return null;
    }


}
