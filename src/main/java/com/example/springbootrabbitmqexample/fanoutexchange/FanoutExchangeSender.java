package com.example.springbootrabbitmqexample.fanoutexchange;

import com.example.springbootrabbitmqexample.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static com.example.springbootrabbitmqexample.fanoutexchange.FanoutExchangeConfig.*;

@Slf4j
@RequiredArgsConstructor
@Profile({"fanout & sender"})
@Component
public class FanoutExchangeSender {

    private final RabbitTemplate template;

    @Scheduled(fixedDelay = 3, initialDelay = 3, timeUnit = TimeUnit.SECONDS)
    public void sendMessage() {
        Message message = new Message("everyone", "Hello, programmers community");

        log.debug("Sending message: {} to fanout exchange: {}", message, EXCHANGE_NAME);

        template.convertAndSend(EXCHANGE_NAME, "", message);
    }
}
