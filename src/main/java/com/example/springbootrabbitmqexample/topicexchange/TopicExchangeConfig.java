package com.example.springbootrabbitmqexample.topicexchange;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("topic")
@Configuration
public class TopicExchangeConfig {
    public static final String EXCHANGE_NAME = "exchange.topic";

    public static final String JAVA_QUEUE_NAME = "java";
    public static final String SPRING_QUEUE_NAME = "java.spring";

    public static final String JAVA_KEY = "java.#";
    public static final String SPRING_KEY = "java.spring";

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue java() {
        return new Queue(JAVA_QUEUE_NAME);
    }

    @Bean
    public Queue spring() {
        return new Queue(SPRING_QUEUE_NAME);
    }

    @Bean
    public Binding bindingJava(TopicExchange exchange, Queue java) {
        return BindingBuilder.bind(java).to(exchange).with(JAVA_KEY);
    }

    @Bean
    public Binding bindingSpring(TopicExchange exchange, Queue spring) {
        return BindingBuilder.bind(spring).to(exchange).with(SPRING_KEY);
    }
}
