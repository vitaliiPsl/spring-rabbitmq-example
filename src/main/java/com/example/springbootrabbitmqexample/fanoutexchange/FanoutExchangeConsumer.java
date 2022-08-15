package com.example.springbootrabbitmqexample.fanoutexchange;

import com.example.springbootrabbitmqexample.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import static com.example.springbootrabbitmqexample.fanoutexchange.FanoutExchangeConfig.*;

@Slf4j
@Profile({"fanout & consumer"})
@Component
public class FanoutExchangeConsumer {

    @RabbitListener(queues = QUEUE1_NAME)
    public void receiveQueue1Message(Message message) {
        log.debug("Received message: {} at queue: {}", message, QUEUE1_NAME);
    }

    @RabbitListener(queues = QUEUE2_NAME)
    public void receiveQueue2Message(Message message) {
        log.debug("Received message: {} at queue: {}", message, QUEUE1_NAME);
    }
}
