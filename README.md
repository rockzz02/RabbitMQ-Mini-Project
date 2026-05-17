# RabbitMQ Tutorial

Minimal Spring Boot application for learning RabbitMQ basics.

This project mirrors the RabbitMQ part of the Spring Boot microservices playlist in a smaller sandbox:

- declare a queue, direct exchange, and binding
- publish a message with `RabbitTemplate`
- consume the message with `@RabbitListener`
- test the flow from a REST endpoint

## Run RabbitMQ

```bash
docker compose up -d
```

RabbitMQ ports:

- AMQP: `localhost:5672`
- Management UI: `http://localhost:15672`
- Username/password: `guest` / `guest`

## Run the App

```bash
./mvnw spring-boot:run
```

## Send a Message

```bash
curl -X POST http://localhost:8080/api/messages \
  -H "Content-Type: application/json" \
  -d '{"message":"hello rabbitmq"}'
```

You should see this in the Spring Boot logs:

```text
Received message from RabbitMQ: hello rabbitmq
```

## Files to Study

- `RabbitMqConfig` creates the queue, exchange, and binding.
- `MessageProducer` publishes messages.
- `MessageConsumer` consumes messages.
- `MessageController` gives you a simple HTTP endpoint for testing.

## Next Learning Steps

1. Change the queue, exchange, and routing key in `application.properties`.
2. Add another queue and listener.
3. Try a fanout exchange.
4. Try sending a JSON object instead of a plain string.
