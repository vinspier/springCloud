package com.vinspier.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String QUEUE = "hello";

    @Bean
    public Queue helloQueue(){
        return new Queue(QUEUE);
    }

}
