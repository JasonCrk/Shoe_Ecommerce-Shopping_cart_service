package com.shoe_ecommerce.shopping_cart.context.cart_item.application.commands.remove;

import com.shoe_ecommerce.shopping_cart.context.cart.domain.Cart;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.exceptions.IsNotOwnerOfCart;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.exceptions.UserDoesNotHaveCart;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.ports.repositories.CartRepository;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.CartItem;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.exceptions.CartItemNotExist;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.ports.repositories.CartItemRepository;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.value_objects.CartItemId;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.UserId;

import com.shoe_ecommerce.shopping_cart.shared.domain.Service;

@Service
public final class CartItemRemover {

    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;

    public CartItemRemover(CartItemRepository cartItemRepository, CartRepository cartRepository) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
    }

    public void remove(CartItemId cartItemId, UserId userId) {
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new CartItemNotExist(cartItemId));

        Cart cart = cartRepository.findByUserId(userId).orElseThrow(UserDoesNotHaveCart::new);

        if (!cart.id().equals(cartItem.cartId())) throw new IsNotOwnerOfCart();

        cartItemRepository.deleteById(cartItem.id());

        cart.incrementTotalCount();
        cartRepository.save(cart);
    }
}
