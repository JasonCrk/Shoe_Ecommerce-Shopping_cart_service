package com.shoe_ecommerce.shopping_cart.context.cart.application.commands.create;

import com.shoe_ecommerce.shopping_cart.context.cart.domain.value_objects.CartId;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.UserId;

import com.shoe_ecommerce.shopping_cart.shared.domain.Service;
import com.shoe_ecommerce.shopping_cart.shared.domain.bus.command.CommandHandler;

@Service
public class CreateCartCommandHandler implements CommandHandler<CreateCartCommand, Void> {

    private final CartCreator creator;

    public CreateCartCommandHandler(CartCreator creator) {
        this.creator = creator;
    }

    @Override
    public Void handle(CreateCartCommand command) {
        this.creator.create(
                new CartId(command.cartId()),
                new UserId(command.userId())
        );

        return null;
    }
}
