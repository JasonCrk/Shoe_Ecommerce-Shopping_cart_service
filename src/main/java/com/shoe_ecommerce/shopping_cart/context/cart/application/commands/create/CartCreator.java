package com.shoe_ecommerce.shopping_cart.context.cart.application.commands.create;

import com.shoe_ecommerce.shopping_cart.context.cart.domain.Cart;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.exceptions.CartAlreadyExist;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.ports.repositories.CartRepository;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.value_objects.CartId;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.UserId;

import com.shoe_ecommerce.shopping_cart.shared.domain.Service;

@Service
public final class CartCreator {

    private final CartRepository cartRepository;

    public CartCreator(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void create(CartId cartId, UserId userId) {
        boolean cartExist = cartRepository.existsByUserId(userId);

        if (cartExist) throw new CartAlreadyExist(userId);

        cartRepository.save(Cart.create(cartId, userId));
    }
}
