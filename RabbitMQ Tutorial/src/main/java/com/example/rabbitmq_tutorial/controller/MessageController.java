package com.example.rabbitmq_tutorial.controller;

import com.example.rabbitmq_tutorial.model.MessageRequest;
import com.example.rabbitmq_tutorial.model.MessageResponse;
import com.example.rabbitmq_tutorial.producer.MessageProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageProducer messageProducer;

    public MessageController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping
    public ResponseEntity<MessageResponse> publish(@RequestBody MessageRequest request) {
        if (request == null || !StringUtils.hasText(request.message())) {
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("Message must not be empty"));
        }

        messageProducer.send(request.message());
        return ResponseEntity.accepted()
                .body(new MessageResponse("Message sent to RabbitMQ"));
    }
}
