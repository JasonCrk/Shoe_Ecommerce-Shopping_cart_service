package com.shoe_ecommerce.shopping_cart.context.cart_item.application.commands.update_count;

import com.shoe_ecommerce.shopping_cart.shared.domain.bus.command.Command;

public record UpdateCartItemCountCommand(
        String cartItemId,
        int count,
        String userId
) implements Command {
}
