package com.shoe_ecommerce.shopping_cart.context.cart_item.application.commands.create;

import com.shoe_ecommerce.shopping_cart.shared.domain.bus.command.Command;

public record CreateCartItemCommand(
        String cartItemId,
        String shoeInventoryId,
        int count,
        String userId
) implements Command {
}
