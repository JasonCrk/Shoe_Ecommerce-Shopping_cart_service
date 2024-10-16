package com.shoe_ecommerce.shopping_cart.context.cart_item.presentation.requests;

import com.shoe_ecommerce.shopping_cart.shared.presentation.validations.is_uuid.IsUuid;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateCartItemRequest(
        @NotBlank(message = "Is required")
        @NotNull(message = "Is required")
        @IsUuid
        String shoeInventoryId,

        @NotNull(message = "Is required")
        @Positive(message = "Must be positive")
        int count
) {
}
