package com.shoe_ecommerce.shopping_cart.context.cart.domain.value_objects;

import com.shoe_ecommerce.shopping_cart.shared.domain.value_objects.IntValueObject;

public final class CartTotalCount extends IntValueObject {

    public CartTotalCount(int value) {
        super(value);
    }

    public CartTotalCount() {
        super(null);
    }

    public static CartTotalCount initialize() {
        return new CartTotalCount(0);
    }

    public CartTotalCount decrement() {
        return new CartTotalCount(value() - 1);
    }

    public CartTotalCount increment() {
        return new CartTotalCount(value() + 1);
    }
}
