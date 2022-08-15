package com.example.springbootrabbitmqexample.defaultexchange;

import com.example.springbootrabbitmqexample.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
@Profile({"default & sender"})
@Component
public class DefaultExchangeSender {

    private final RabbitTemplate template;
    private final Queue queue;

    @Scheduled(fixedDelay = 5, initialDelay = 2, timeUnit = TimeUnit.SECONDS)
    public void sendGreeting() {
        Message message = new Message(queue.getName(), "Hello, default exchange");

        log.debug("Sending message: {} to default exchange. Queue name: {}", message, queue.getName());

        template.convertAndSend(queue.getName(), message);
    }
}
