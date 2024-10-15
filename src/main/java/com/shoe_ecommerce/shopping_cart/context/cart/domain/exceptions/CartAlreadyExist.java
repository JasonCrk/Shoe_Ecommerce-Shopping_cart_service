package com.shoe_ecommerce.shopping_cart.context.cart.domain.exceptions;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.UserId;
import com.shoe_ecommerce.shopping_cart.shared.domain.exceptions.DomainError;

public class CartAlreadyExist extends DomainError {
    public CartAlreadyExist(UserId userId) {
        super("cart_already_exist", String.format("The user <%s> already has his cart", userId.value()));
    }
}
