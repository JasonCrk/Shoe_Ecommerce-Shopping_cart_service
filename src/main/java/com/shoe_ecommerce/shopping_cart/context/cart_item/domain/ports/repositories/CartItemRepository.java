package com.shoe_ecommerce.shopping_cart.context.cart_item.domain.ports.repositories;

import com.shoe_ecommerce.shopping_cart.context.cart.domain.value_objects.CartId;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.CartItem;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.value_objects.CartItemId;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository {
    List<CartItem> findAllByCartId(CartId cartId);
    Optional<CartItem> findById(CartItemId cartItemId);

    CartItem save(CartItem cartItem);

    void deleteById(CartItemId cartItemId);
}
