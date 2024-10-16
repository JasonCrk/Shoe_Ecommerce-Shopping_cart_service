package com.shoe_ecommerce.shopping_cart.context.cart_item.application.commands.create;

import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.value_objects.CartItemCount;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.value_objects.CartItemId;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.ShoeInventoryId;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.UserId;

import com.shoe_ecommerce.shopping_cart.shared.domain.Service;
import com.shoe_ecommerce.shopping_cart.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateCartItemCommandHandler implements CommandHandler<CreateCartItemCommand, Void> {

    private final CartItemCreator creator;

    public CreateCartItemCommandHandler(CartItemCreator creator) {
        this.creator = creator;
    }

    @Override
    public Void handle(CreateCartItemCommand command) {
        this.creator.create(
                new CartItemId(command.cartItemId()),
                new CartItemCount(command.count()),
                new ShoeInventoryId(command.shoeInventoryId()),
                new UserId(command.userId())
        );

        return null;
    }
}
