package com.example.springbootrabbitmqexample.directexchange;

import com.example.springbootrabbitmqexample.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Profile({"direct & consumer"})
@Component
public class DirectExchangeConsumer {

    @RabbitListener(queues = DirectExchangeConfig.JAVA_QUEUE_NAME)
    public void receiveJavaQueueMessage(Message message) {
        log.debug("Received message: {} at queue: {}", message, DirectExchangeConfig.JAVA_QUEUE_NAME);
    }

    @RabbitListener(queues = DirectExchangeConfig.GOLANG_QUEUE_NAME)
    public void receiveGolangQueueMessage(Message message) {
        log.debug("Received message: {} at queue: {}", message, DirectExchangeConfig.GOLANG_QUEUE_NAME);
    }
}
