package com.example.springbootrabbitmqexample.defaultexchange;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("default")
@Configuration
public class DefaultExchangeConfig {
    public static final String QUEUE_NAME = "default-queue";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME);
    }

}
