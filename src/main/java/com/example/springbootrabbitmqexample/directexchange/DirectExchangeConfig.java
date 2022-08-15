package com.example.springbootrabbitmqexample.directexchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("direct")
@Configuration
public class DirectExchangeConfig {
    public static final String EXCHANGE_NAME = "exchange.direct";

    public static final String JAVA_QUEUE_NAME = "java-queue";
    public static final String GOLANG_QUEUE_NAME = "golang-queue";

    public static final String JAVA_ROUTING_KEY = "java";
    public static final String GOLANG_ROUTING_KEY = "golang";

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue java() {
        return new Queue(JAVA_QUEUE_NAME);
    }

    @Bean
    public Queue golang() {
        return new Queue(GOLANG_QUEUE_NAME);
    }

    @Bean
    public Binding bindingJava(DirectExchange exchange, Queue java) {
        return BindingBuilder.bind(java).to(exchange).with(JAVA_ROUTING_KEY);
    }

    @Bean
    public Binding bindingGolang(DirectExchange exchange, Queue golang) {
        return BindingBuilder.bind(golang).to(exchange).with(GOLANG_ROUTING_KEY);
    }

}
