package com.example.springbootrabbitmqexample.topicexchange;

import com.example.springbootrabbitmqexample.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.example.springbootrabbitmqexample.topicexchange.TopicExchangeConfig.*;

@Slf4j
@Profile({"topic & consumer"})
@Component
public class TopicExchangeConsumer {

    @RabbitListener(queues = JAVA_QUEUE_NAME)
    public void receiveJavaMessage(Message message) {
        log.debug("Received message: {} at queue: {}", message, JAVA_QUEUE_NAME);
    }

    @RabbitListener(queues = SPRING_KEY)
    public void receiveSpringMessage(Message message) {
        log.debug("Received message: {} at queue: {}", message, SPRING_QUEUE_NAME);
    }
}
