package com.shoe_ecommerce.shopping_cart.context.cart.application.commands.create;

import com.shoe_ecommerce.shopping_cart.shared.domain.bus.command.Command;

public record CreateCartCommand(String cartId, String userId) implements Command {
}
