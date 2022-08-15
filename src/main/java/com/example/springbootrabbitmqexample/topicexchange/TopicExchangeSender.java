package com.example.springbootrabbitmqexample.topicexchange;

import com.example.springbootrabbitmqexample.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static com.example.springbootrabbitmqexample.topicexchange.TopicExchangeConfig.*;

@Slf4j
@RequiredArgsConstructor
@Profile({"topic & sender"})
@Component
public class TopicExchangeSender {

    private final RabbitTemplate template;

    @Scheduled(fixedDelay = 3, initialDelay = 3, timeUnit = TimeUnit.SECONDS)
    public void sendJavaMessage() {
        Message message = new Message("java", "Hello, java community");

        log.debug("Sending message: {} to topic exchange: {}. Routing key: {}", message, EXCHANGE_NAME, JAVA_KEY);

        template.convertAndSend(EXCHANGE_NAME, JAVA_KEY, message);
    }

    @Scheduled(fixedDelay = 7, initialDelay = 7, timeUnit = TimeUnit.SECONDS)
    public void sendSpringMessage() {
        Message message = new Message("spring", "Hello, spring community");

        log.debug("Sending message: {} to topic exchange: {}. Routing key: {}", message, EXCHANGE_NAME, SPRING_KEY);

        template.convertAndSend(EXCHANGE_NAME, SPRING_KEY, message);
    }
}
