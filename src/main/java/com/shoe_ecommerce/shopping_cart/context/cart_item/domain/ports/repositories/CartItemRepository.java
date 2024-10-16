package com.shoe_ecommerce.shopping_cart.context.cart_item.domain.ports.repositories;

import com.shoe_ecommerce.shopping_cart.context.cart.domain.value_objects.CartId;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.CartItem;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.value_objects.CartItemId;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.ShoeInventoryId;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository {
    Optional<CartItem> findById(CartItemId cartItemId);
    List<CartItem> findAllByCartId(CartId cartId);

    boolean existsByCartIdAndShoeInventoryId(CartId cartId, ShoeInventoryId shoeInventoryId);

    CartItem save(CartItem cartItem);

    void deleteById(CartItemId cartItemId);
    void deleteAllByCartId(CartId cartId);
}
