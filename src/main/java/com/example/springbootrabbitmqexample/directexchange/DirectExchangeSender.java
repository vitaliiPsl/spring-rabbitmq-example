package com.example.springbootrabbitmqexample.directexchange;

import com.example.springbootrabbitmqexample.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static com.example.springbootrabbitmqexample.directexchange.DirectExchangeConfig.*;

@Slf4j
@RequiredArgsConstructor
@Profile({"direct & sender"})
@Component
public class DirectExchangeSender {

    private final RabbitTemplate template;

    @Scheduled(fixedDelay = 3, initialDelay = 3, timeUnit = TimeUnit.SECONDS)
    public void sendJavaMessage() {
        Message message = new Message("java_community", "Hello, java community");

        log.debug("Sending java message: {} to direct exchange: {}. Routing key: {}", message, EXCHANGE_NAME, JAVA_ROUTING_KEY);

        template.convertAndSend(EXCHANGE_NAME, JAVA_ROUTING_KEY, message);
    }

    @Scheduled(fixedDelay = 5, initialDelay = 5, timeUnit = TimeUnit.SECONDS)
    public void sendGolangMessage() {
        Message message = new Message("golang_community", "Hello, golang community");

        log.debug("Sending golang message: {} to direct exchange: {}. Routing key: {}", message, EXCHANGE_NAME, GOLANG_ROUTING_KEY);

        template.convertAndSend(EXCHANGE_NAME, GOLANG_ROUTING_KEY, message);
    }
}
