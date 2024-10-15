package com.shoe_ecommerce.shopping_cart.context.cart.infrastructure.adapters.repositories;

import com.shoe_ecommerce.shopping_cart.context.cart.domain.Cart;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.ports.repositories.CartRepository;
import com.shoe_ecommerce.shopping_cart.context.cart.infrastructure.persistence.CartMapper;
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
        return repository.findByUserId(userId.uuid()).map(CartMapper::toEntity);
    }

    @Override
    public boolean existsByUserId(UserId userId) {
        return repository.existsByUserId(userId.uuid());
    }

    @Override
    public Cart save(Cart cart) {
        return CartMapper.toEntity(repository.save(CartMapper.toModel(cart)));
    }
}
