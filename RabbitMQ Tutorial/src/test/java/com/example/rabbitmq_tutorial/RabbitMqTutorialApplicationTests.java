package com.example.rabbitmq_tutorial;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.rabbitmq.listener.simple.auto-startup=false")
class RabbitMqTutorialApplicationTests {

    @Test
    void contextLoads() {
    }

}
