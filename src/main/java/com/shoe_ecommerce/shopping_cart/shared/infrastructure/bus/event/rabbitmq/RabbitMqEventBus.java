package com.shoe_ecommerce.shopping_cart.shared.infrastructure.bus.event.rabbitmq;

import com.shoe_ecommerce.shopping_cart.shared.domain.bus.event.DomainEvent;
import com.shoe_ecommerce.shopping_cart.shared.domain.bus.event.EventBus;

import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.AmqpException;

import java.util.List;

@Slf4j
public final class RabbitMqEventBus implements EventBus {

    private final RabbitMqPublisher publisher;
    private final String exchangeName;

    public RabbitMqEventBus(RabbitMqPublisher publisher) {
        this.publisher = publisher;
        this.exchangeName = "domain_events";
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    public void publish(DomainEvent domainEvent) {
        try {
            this.publisher.publish(domainEvent, exchangeName);
        } catch (AmqpException exception) {
            log.error(String.format("Erro when publishing the domain event <%s> <%s>", domainEvent.eventName(), domainEvent.eventId()));
        }
    }
}
