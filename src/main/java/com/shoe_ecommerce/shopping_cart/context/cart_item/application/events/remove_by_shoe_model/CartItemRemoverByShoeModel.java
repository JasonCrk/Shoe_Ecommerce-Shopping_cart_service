package com.shoe_ecommerce.shopping_cart.context.cart_item.application.events.remove_by_shoe_model;

import com.shoe_ecommerce.shopping_cart.context.cart.domain.ports.repositories.CartRepository;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.value_objects.CartId;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.CartItem;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.ports.repositories.CartItemRepository;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.ShoeModelId;

import com.shoe_ecommerce.shopping_cart.shared.domain.Service;

import java.util.HashMap;
import java.util.List;

@Service
public final class CartItemRemoverByShoeModel {

    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;

    public CartItemRemoverByShoeModel(CartItemRepository cartItemRepository, CartRepository cartRepository) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
    }

    public void removeAllByShoeModel(ShoeModelId shoeModelId) {
        List<CartItem> cartItems = cartItemRepository.findAllByShoeModelId(shoeModelId);

        HashMap<String, Integer> reductionsOfCarts = new HashMap<>();

        cartItems.forEach(cartItem -> {
            reductionsOfCarts.put(
                    cartItem.cartId().value(),
                    reductionsOfCarts.getOrDefault(cartItem.cartId().value(), 0) + 1
            );
        });

        reductionsOfCarts.forEach((cartId, reduction) -> {
            cartRepository.reduceCountById(new CartId(cartId), reduction);
        });

        cartItemRepository.deleteAllByShoeModelId(shoeModelId);
    }
}
