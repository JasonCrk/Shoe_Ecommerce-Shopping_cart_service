package com.shoe_ecommerce.shopping_cart.context.shared.domain.entities;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.ShoeVariantId;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.ShoeVariantIsDiscontinued;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.ShoeVariantName;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.ShoeVariantPrice;

public record ShoeVariant(
        ShoeVariantId id,
        ShoeVariantName name,
        ShoeVariantPrice price,
        ShoeVariantIsDiscontinued isDiscontinued
) {
}
