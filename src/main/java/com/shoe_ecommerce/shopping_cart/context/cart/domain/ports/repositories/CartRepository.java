package com.shoe_ecommerce.shopping_cart.context.cart.domain.ports.repositories;

import com.shoe_ecommerce.shopping_cart.context.cart.domain.Cart;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.value_objects.CartId;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.UserId;

import java.util.Optional;

public interface CartRepository {
    Optional<Cart> findByUserId(UserId userId);

    boolean existsByIdAndUserId(CartId cartId, UserId userId);
    boolean existsByUserId(UserId userId);

    Cart save(Cart cart);
}
