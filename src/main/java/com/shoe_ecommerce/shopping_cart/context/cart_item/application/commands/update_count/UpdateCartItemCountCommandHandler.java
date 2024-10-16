package com.shoe_ecommerce.shopping_cart.context.cart_item.application.commands.update_count;

import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.value_objects.CartItemCount;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.value_objects.CartItemId;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.UserId;

import com.shoe_ecommerce.shopping_cart.shared.domain.Service;
import com.shoe_ecommerce.shopping_cart.shared.domain.bus.command.CommandHandler;

@Service
public final class UpdateCartItemCountCommandHandler implements CommandHandler<UpdateCartItemCountCommand, Void> {

    private final UpdateCartItemCount updateCartItemCount;

    public UpdateCartItemCountCommandHandler(UpdateCartItemCount updateCartItemCount) {
        this.updateCartItemCount = updateCartItemCount;
    }

    @Override
    public Void handle(UpdateCartItemCountCommand command) {
        this.updateCartItemCount.update(
                new CartItemId(command.cartItemId()),
                new CartItemCount(command.count()),
                new UserId(command.userId())
        );

        return null;
    }
}
