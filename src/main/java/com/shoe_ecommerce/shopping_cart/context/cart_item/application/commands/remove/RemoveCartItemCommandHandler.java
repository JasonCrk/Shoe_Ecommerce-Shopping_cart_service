package com.shoe_ecommerce.shopping_cart.context.cart_item.application.commands.remove;

import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.value_objects.CartItemId;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.UserId;

import com.shoe_ecommerce.shopping_cart.shared.domain.Service;
import com.shoe_ecommerce.shopping_cart.shared.domain.bus.command.CommandHandler;

@Service
public final class RemoveCartItemCommandHandler implements CommandHandler<RemoveCartItemCommand, Void> {

    private final CartItemRemover remover;

    public RemoveCartItemCommandHandler(CartItemRemover remover) {
        this.remover = remover;
    }

    @Override
    public Void handle(RemoveCartItemCommand command) {
        this.remover.remove(
                new CartItemId(command.cartItemId()),
                new UserId(command.userId())
        );

        return null;
    }
}
