package com.shoe_ecommerce.shopping_cart.shared.domain.domain_events.shoe_model;

import com.shoe_ecommerce.shopping_cart.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public final class ShoeModelDiscontinuedDomainEvent extends DomainEvent {
    private final String id;

    public ShoeModelDiscontinuedDomainEvent(String aggregateId, String eventId, String occurredOn, String id) {
        super(aggregateId, eventId, occurredOn);
        this.id = id;
    }

    public ShoeModelDiscontinuedDomainEvent(String id) {
        super(id);
        this.id = id;
    }

    public ShoeModelDiscontinuedDomainEvent() {
        super(null);
        this.id = null;
    }

    public String id() {
        return id;
    }

    @Override
    public String eventName() {
        return "shoe_model.discontinued";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<>() {{
            put("id", id);
        }};
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new ShoeModelDiscontinuedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("id")
        );
    }
}
