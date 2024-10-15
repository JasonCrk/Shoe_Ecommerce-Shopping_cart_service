package com.shoe_ecommerce.shopping_cart.context.cart_item.domain.value_objects;

import com.shoe_ecommerce.shopping_cart.shared.domain.value_objects.Identifier;

public final class CartItemId extends Identifier {

    public CartItemId(String value) {
        super(value);
    }

    public CartItemId() {
    }
}
