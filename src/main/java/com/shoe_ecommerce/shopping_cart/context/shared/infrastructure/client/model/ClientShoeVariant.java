package com.shoe_ecommerce.shopping_cart.context.shared.infrastructure.client.model;

public record ClientShoeVariant(
        String id,
        String name,
        double price,
        boolean isDiscontinued
) {
}
