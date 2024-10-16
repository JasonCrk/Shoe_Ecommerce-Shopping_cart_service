package com.shoe_ecommerce.shopping_cart.context.cart_item.presentation.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UpdateCartItemCountRequest(
        @NotNull(message = "Is required")
        @Positive(message = "Must be positive")
        int count
) {
}
