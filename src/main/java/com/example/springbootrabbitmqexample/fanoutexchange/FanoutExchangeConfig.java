package com.example.springbootrabbitmqexample.fanoutexchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("fanout")
@Configuration
public class FanoutExchangeConfig {
    public static final String EXCHANGE_NAME = "exchange.fanout";

    public static final String QUEUE1_NAME = "queue1";
    public static final String QUEUE2_NAME = "queue2";

    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue queue1() {
        return new Queue(QUEUE1_NAME);
    }

    @Bean
    public Queue queue2() {
        return new Queue(QUEUE2_NAME);
    }

    @Bean
    public Binding binding1(FanoutExchange exchange, Queue queue1) {
        return BindingBuilder.bind(queue1).to(exchange);
    }

    @Bean
    public Binding binding2(FanoutExchange exchange, Queue queue2) {
        return BindingBuilder.bind(queue2).to(exchange);
    }
}
