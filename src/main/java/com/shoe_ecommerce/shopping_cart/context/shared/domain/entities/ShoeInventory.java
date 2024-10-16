package com.shoe_ecommerce.shopping_cart.context.shared.domain.entities;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.ShoeInventoryId;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.ShoeInventoryStock;

public record ShoeInventory(
        ShoeInventoryId id,
        ShoeInventoryStock stock,
        ShoeVariant variant
) {
}
