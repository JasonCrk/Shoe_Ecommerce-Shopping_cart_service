package com.shoe_ecommerce.shopping_cart.context.cart_item.application.commands.remove;

import com.shoe_ecommerce.shopping_cart.shared.domain.bus.command.Command;

public record RemoveCartItemCommand(String cartItemId, String userId) implements Command {
}
