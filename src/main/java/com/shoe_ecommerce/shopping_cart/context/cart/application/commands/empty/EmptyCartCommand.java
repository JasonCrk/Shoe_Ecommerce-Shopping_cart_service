package com.shoe_ecommerce.shopping_cart.context.cart.application.commands.empty;

import com.shoe_ecommerce.shopping_cart.shared.domain.bus.command.Command;

public record EmptyCartCommand(String userId) implements Command {
}
