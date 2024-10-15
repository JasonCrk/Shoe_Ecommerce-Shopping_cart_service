package com.shoe_ecommerce.shopping_cart.context.cart.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "carts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JpaCart {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "user_id", columnDefinition = "BINARY(16)", nullable = false, unique = true)
    private UUID userId;

    @Column(name = "total_count", columnDefinition = "SMALLINT UNSIGNED", nullable = false)
    private int totalCount;
}
