package com.shoe_ecommerce.shopping_cart.shared.domain.bus.query;

public interface QueryBus {
    Response ask(Query query);
}
