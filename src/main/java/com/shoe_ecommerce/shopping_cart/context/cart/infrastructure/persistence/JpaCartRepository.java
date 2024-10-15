package com.shoe_ecommerce.shopping_cart.context.cart.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaCartRepository extends JpaRepository<JpaCart, UUID> {
}
