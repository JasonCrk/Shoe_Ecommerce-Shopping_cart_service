package com.shoe_ecommerce.shopping_cart.context.cart_item.domain.exceptions;

import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.value_objects.CartItemId;

import com.shoe_ecommerce.shopping_cart.shared.domain.exceptions.DomainError;

public class CartItemNotExist extends DomainError {
    public CartItemNotExist(CartItemId id) {
        super("cart_item_not_exist", String.format("Cart item <%s> doesn't exist", id.value()));
    }
}
