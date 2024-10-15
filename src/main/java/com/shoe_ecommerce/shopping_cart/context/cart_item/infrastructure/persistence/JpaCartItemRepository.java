package com.shoe_ecommerce.shopping_cart.context.cart_item.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaCartItemRepository extends JpaRepository<JpaCartItem, UUID> {
}
