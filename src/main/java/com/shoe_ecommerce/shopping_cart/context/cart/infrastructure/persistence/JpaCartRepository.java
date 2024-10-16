package com.shoe_ecommerce.shopping_cart.context.cart.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaCartRepository extends JpaRepository<JpaCart, UUID> {
    Optional<JpaCart> findByUserId(UUID userId);

    boolean existsByUserId(UUID userId);
    boolean existsByIdAndUserId(UUID id, UUID userId);
}
