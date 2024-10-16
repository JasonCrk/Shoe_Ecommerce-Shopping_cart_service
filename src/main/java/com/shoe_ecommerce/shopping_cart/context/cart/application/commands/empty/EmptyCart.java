package com.shoe_ecommerce.shopping_cart.context.cart.application.commands.empty;

import com.shoe_ecommerce.shopping_cart.context.cart.domain.Cart;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.exceptions.UserDoesNotHaveCart;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.ports.repositories.CartRepository;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.ports.repositories.CartItemRepository;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.UserId;

import com.shoe_ecommerce.shopping_cart.shared.domain.Service;

@Service
public final class EmptyCart {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public EmptyCart(CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public void empty(UserId userId) {
        Cart cart = cartRepository.findByUserId(userId).orElseThrow(UserDoesNotHaveCart::new);

        cartItemRepository.deleteAllByCartId(cart.id());
        cart.emptyItems();

        cartRepository.save(cart);
    }
}
