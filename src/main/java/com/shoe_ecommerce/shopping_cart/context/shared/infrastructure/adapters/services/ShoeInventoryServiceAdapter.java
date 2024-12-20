package com.shoe_ecommerce.shopping_cart.context.shared.infrastructure.adapters.services;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.entities.ShoeInventory;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.ports.services.ShoeInventoryService;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.ShoeInventoryId;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.ShoeModelId;
import com.shoe_ecommerce.shopping_cart.context.shared.infrastructure.client.mappers.ShoeInventoryMapper;
import com.shoe_ecommerce.shopping_cart.context.shared.infrastructure.client.ShoeInventoryMicroserviceClient;

import com.shoe_ecommerce.shopping_cart.shared.domain.Service;

import java.util.List;

@Service
public final class ShoeInventoryServiceAdapter implements ShoeInventoryService {

    private final ShoeInventoryMicroserviceClient client;

    public ShoeInventoryServiceAdapter(ShoeInventoryMicroserviceClient client) {
        this.client = client;
    }

    @Override
    public ShoeInventory getById(ShoeInventoryId id) {
        return ShoeInventoryMapper.toEntity(client.getById(id.uuid()));
    }

    @Override
    public List<ShoeInventory> getAllByShoeModelId(ShoeModelId shoeModelId) {
        return client.findByShoeModelId(shoeModelId.uuid()).stream()
                .map(ShoeInventoryMapper::toEntity)
                .toList();
    }
}
