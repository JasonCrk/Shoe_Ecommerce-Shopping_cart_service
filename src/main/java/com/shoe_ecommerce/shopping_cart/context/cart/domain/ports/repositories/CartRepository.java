package com.shoe_ecommerce.shopping_cart.context.cart.domain.ports.repositories;

import com.shoe_ecommerce.shopping_cart.context.cart.domain.Cart;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.UserId;

import java.util.Optional;

public interface CartRepository {
    Optional<Cart> findByUserId(UserId userId);
}
