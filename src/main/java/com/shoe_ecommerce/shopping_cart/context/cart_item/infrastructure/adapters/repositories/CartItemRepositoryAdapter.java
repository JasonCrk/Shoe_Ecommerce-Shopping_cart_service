package com.shoe_ecommerce.shopping_cart.context.cart_item.infrastructure.adapters.repositories;

import com.shoe_ecommerce.shopping_cart.context.cart.domain.value_objects.CartId;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.CartItem;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.ports.repositories.CartItemRepository;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.value_objects.CartItemId;
import com.shoe_ecommerce.shopping_cart.context.cart_item.infrastructure.persistence.CartItemMapper;
import com.shoe_ecommerce.shopping_cart.context.cart_item.infrastructure.persistence.JpaCartItemRepository;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.ShoeInventoryId;

import com.shoe_ecommerce.shopping_cart.shared.domain.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public final class CartItemRepositoryAdapter implements CartItemRepository {

    private final JpaCartItemRepository repository;

    public CartItemRepositoryAdapter(JpaCartItemRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CartItem> findAllByCartId(CartId cartId) {
        return repository.findByCartId(cartId.uuid()).stream()
                .map(CartItemMapper::toEntity)
                .toList();
    }

    @Override
    public boolean existsByCartIdAndShoeInventoryId(CartId cartId, ShoeInventoryId shoeInventoryId) {
        return repository.existsByCartIdAndShoeInventoryId(cartId.uuid(), shoeInventoryId.uuid());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CartItem> findById(CartItemId cartItemId) {
        return repository.findById(cartItemId.uuid()).map(CartItemMapper::toEntity);
    }

    @Override
    @Transactional
    public CartItem save(CartItem cartItem) {
        return CartItemMapper.toEntity(repository.save(CartItemMapper.toModel(cartItem)));
    }

    @Override
    @Transactional
    public void deleteById(CartItemId cartItemId) {
        repository.deleteById(cartItemId.uuid());
    }
}
