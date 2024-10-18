package com.shoe_ecommerce.shopping_cart.context.cart.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface JpaCartRepository extends JpaRepository<JpaCart, UUID> {
    Optional<JpaCart> findByUserId(UUID userId);

    boolean existsByUserId(UUID userId);
    boolean existsByIdAndUserId(UUID id, UUID userId);

    @Modifying
    @Query(value = """
            UPDATE JpaCart SET totalCount = totalCount - :reduction WHERE id = :cartId
            """)
    void reduceCountById(@Param("cartId") UUID id, @Param("reduction") int reduce);
}
