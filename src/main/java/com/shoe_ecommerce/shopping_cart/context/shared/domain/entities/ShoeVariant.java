package com.shoe_ecommerce.shopping_cart.context.shared.domain.entities;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.*;

public record ShoeVariant(
        ShoeVariantId id,
        ShoeVariantName name,
        ShoeVariantPrice price,
        ShoeVariantIsDiscontinued isDiscontinued,
        ShoeModelId modelId
) {
}
