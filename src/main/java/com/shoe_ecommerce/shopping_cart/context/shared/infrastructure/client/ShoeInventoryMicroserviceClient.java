package com.shoe_ecommerce.shopping_cart.context.shared.infrastructure.client;

import com.shoe_ecommerce.shopping_cart.context.shared.infrastructure.client.model.ClientShoeInventory;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "${microservices.shoe-inventory-service}")
public interface ShoeInventoryMicroserviceClient {

    @GetMapping("/api/v1/shoe-inventories/{id}")
    ClientShoeInventory getById(@PathVariable("id") UUID shoeInventoryId);

    @GetMapping("/api/v1/shoe-inventories/shoe-model/{id}")
    List<ClientShoeInventory> findByShoeModelId(@PathVariable("id") UUID shoeModelId);
}
