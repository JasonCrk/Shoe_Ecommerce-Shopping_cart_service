package com.shoe_ecommerce.shopping_cart.shared.domain.bus.command;

public interface CommandBus {
    <R> R dispatch(Command command);
}
