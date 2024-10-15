package com.shoe_ecommerce.shopping_cart.shared.domain.bus.command;

public interface CommandHandler<C extends Command, R> {
    R handle(C command);
}
