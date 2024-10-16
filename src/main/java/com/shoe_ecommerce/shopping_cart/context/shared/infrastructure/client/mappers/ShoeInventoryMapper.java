package com.shoe_ecommerce.shopping_cart.context.shared.infrastructure.client.mappers;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.entities.ShoeInventory;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.ShoeInventoryId;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.ShoeInventoryStock;
import com.shoe_ecommerce.shopping_cart.context.shared.infrastructure.client.model.ClientShoeInventory;

public final class ShoeInventoryMapper {

    public static ShoeInventory toEntity(ClientShoeInventory inventory) {
        return new ShoeInventory(
                new ShoeInventoryId(inventory.id()),
                new ShoeInventoryStock(inventory.stock()),
                ShoeVariantMapper.toEntity(inventory.variant())
        );
    }
}
