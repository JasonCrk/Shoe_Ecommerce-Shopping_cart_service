package com.shoe_ecommerce.shopping_cart.context.cart.application.commands.empty;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.UserId;

import com.shoe_ecommerce.shopping_cart.shared.domain.Service;
import com.shoe_ecommerce.shopping_cart.shared.domain.bus.command.CommandHandler;

@Service
public final class EmptyCartCommandHandler implements CommandHandler<EmptyCartCommand, Void> {

    private final EmptyCart emptyCart;

    public EmptyCartCommandHandler(EmptyCart emptyCart) {
        this.emptyCart = emptyCart;
    }

    @Override
    public Void handle(EmptyCartCommand command) {
        this.emptyCart.empty(new UserId(command.userId()));

        return null;
    }
}
