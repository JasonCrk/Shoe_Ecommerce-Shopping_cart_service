package com.shoe_ecommerce.shopping_cart.context.cart_item.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaCartItemRepository extends JpaRepository<JpaCartItem, UUID> {
    List<JpaCartItem> findByCartId(UUID cartId);

    boolean existsByCartIdAndShoeInventoryId(UUID cartId, UUID shoeInventoryId);

    void deleteAllByCartId(UUID cartId);
}
