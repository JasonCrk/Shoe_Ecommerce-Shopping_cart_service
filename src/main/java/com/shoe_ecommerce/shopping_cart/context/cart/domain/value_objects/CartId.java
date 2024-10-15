package com.shoe_ecommerce.shopping_cart.context.cart.domain.value_objects;

import com.shoe_ecommerce.shopping_cart.shared.domain.value_objects.Identifier;

public final class CartId extends Identifier {

    public CartId(String value) {
        super(value);
    }

    public CartId() {
    }
}
