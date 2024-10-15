package com.shoe_ecommerce.shopping_cart.context.cart.domain.exceptions;

import com.shoe_ecommerce.shopping_cart.context.cart.domain.value_objects.CartId;

import com.shoe_ecommerce.shopping_cart.shared.domain.exceptions.DomainError;

public class CartNotExist extends DomainError {
    public CartNotExist(CartId id) {
        super("cart_not_exist", String.format("Cart <%s> doesn't exist", id.value()));
    }
}
