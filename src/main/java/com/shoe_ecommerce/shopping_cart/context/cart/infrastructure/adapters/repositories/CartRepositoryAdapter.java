package com.shoe_ecommerce.shopping_cart.context.cart.infrastructure.adapters.repositories;

import com.shoe_ecommerce.shopping_cart.context.cart.domain.Cart;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.ports.repositories.CartRepository;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.value_objects.CartId;
import com.shoe_ecommerce.shopping_cart.context.cart.infrastructure.persistence.CartMapper;
import com.shoe_ecommerce.shopping_cart.context.cart.infrastructure.persistence.JpaCartRepository;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.UserId;

import com.shoe_ecommerce.shopping_cart.shared.domain.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public final class CartRepositoryAdapter implements CartRepository {

    private final JpaCartRepository repository;

    public CartRepositoryAdapter(JpaCartRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cart> findByUserId(UserId userId) {
        return repository.findByUserId(userId.uuid()).map(CartMapper::toEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByIdAndUserId(CartId cartId, UserId userId) {
        return repository.existsByIdAndUserId(cartId.uuid(), userId.uuid());
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByUserId(UserId userId) {
        return repository.existsByUserId(userId.uuid());
    }

    @Override
    @Transactional
    public Cart save(Cart cart) {
        return CartMapper.toEntity(repository.save(CartMapper.toModel(cart)));
    }

    @Override
    @Transactional
    public void reduceCountById(CartId cartId, int reduction) {
        repository.reduceCountById(cartId.uuid(), reduction);
    }
}
