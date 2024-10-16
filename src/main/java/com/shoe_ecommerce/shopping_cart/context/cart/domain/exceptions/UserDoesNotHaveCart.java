package com.shoe_ecommerce.shopping_cart.context.cart.domain.exceptions;

import com.shoe_ecommerce.shopping_cart.shared.domain.exceptions.DomainError;

public class UserDoesNotHaveCart extends DomainError {
    public UserDoesNotHaveCart() {
        super("cart_not_exist", "The user doesn't have a cart");
    }
}
