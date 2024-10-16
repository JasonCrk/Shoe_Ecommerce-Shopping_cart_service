package com.shoe_ecommerce.shopping_cart.context.shared.infrastructure.client.model;

public record ClientShoeInventory(
        String id,
        int stock,
        ClientShoeVariant variant
) {
}
