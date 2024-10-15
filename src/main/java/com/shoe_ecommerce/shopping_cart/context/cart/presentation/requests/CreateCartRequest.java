package com.shoe_ecommerce.shopping_cart.context.cart.presentation.requests;

import com.shoe_ecommerce.shopping_cart.shared.presentation.validations.is_uuid.IsUuid;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCartRequest(
        @IsUuid
        @NotNull(message = "Is required")
        @NotBlank(message = "Is required")
        String userId
) {
}
