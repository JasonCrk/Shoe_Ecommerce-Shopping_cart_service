package com.shoe_ecommerce.shopping_cart.context.cart.infrastructure.adapters.repositories;

import com.shoe_ecommerce.shopping_cart.context.cart.domain.Cart;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.ports.repositories.CartRepository;
import com.shoe_ecommerce.shopping_cart.context.cart.infrastructure.persistence.JpaCartRepository;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.UserId;

import com.shoe_ecommerce.shopping_cart.shared.domain.Service;

import java.util.Optional;

@Service
public final class CartRepositoryAdapter implements CartRepository {

    private final JpaCartRepository repository;

    public CartRepositoryAdapter(JpaCartRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Cart> findByUserId(UserId userId) {
        return Optional.empty();
    }
}
