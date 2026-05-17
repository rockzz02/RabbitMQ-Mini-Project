package com.example.rabbitmq_tutorial.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;
    private final String exchangeName;
    private final String routingKey;

    public MessageProducer(
            RabbitTemplate rabbitTemplate,
            @Value("${rabbitmq.exchange.name}") String exchangeName,
            @Value("${rabbitmq.routing.key}") String routingKey
    ) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchangeName = exchangeName;
        this.routingKey = routingKey;
    }

    public void send(String message) {
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }
}
