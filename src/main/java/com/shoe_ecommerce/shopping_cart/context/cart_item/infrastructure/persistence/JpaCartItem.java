package com.shoe_ecommerce.shopping_cart.context.cart_item.infrastructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "cart_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JpaCartItem {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "cart_id", columnDefinition = "BINARY(16)", nullable = false)
    private UUID cartId;

    @Column(name = "shoe_inventory_id", columnDefinition = "BINARY(16)", nullable = false)
    private UUID shoeInventoryId;

    @Column(name = "shoe_variant_id", columnDefinition = "BINARY(16)", nullable = false)
    private UUID shoeVariantId;

    @Column(name = "shoe_model_id", columnDefinition = "BINARY(16)", nullable = false)
    private UUID shoeModelId;

    @Column(name = "count", columnDefinition = "SMALLINT UNSIGNED", nullable = false)
    private int count;
}
