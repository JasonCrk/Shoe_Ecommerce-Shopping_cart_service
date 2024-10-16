package com.shoe_ecommerce.shopping_cart.context.cart.domain.exceptions;

import com.shoe_ecommerce.shopping_cart.shared.domain.exceptions.DomainError;

public class IsNotOwnerOfCart extends DomainError {
    public IsNotOwnerOfCart() {
        super("is_not_owner_of_cart", "The user is not owner of the cart");
    }
}
