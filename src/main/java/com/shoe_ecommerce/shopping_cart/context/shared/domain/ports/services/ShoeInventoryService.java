package com.shoe_ecommerce.shopping_cart.context.shared.domain.ports.services;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.entities.ShoeInventory;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.ShoeInventoryId;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.ShoeModelId;

import java.util.List;

public interface ShoeInventoryService {
    ShoeInventory getById(ShoeInventoryId id);
    List<ShoeInventory> getAllByShoeModelId(ShoeModelId shoeModelId);
}
