package com.example.springbootrabbitmqexample.defaultexchange;


import com.example.springbootrabbitmqexample.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Profile("default & consumer")
@Component
public class DefaultExchangeConsumer {

    @RabbitListener(queues = DefaultExchangeConfig.QUEUE_NAME)
    public void receiveGreeting(Message message) {
        log.debug("Received message: {} at queue", message);
    }
}
