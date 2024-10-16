package com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects;

import com.shoe_ecommerce.shopping_cart.shared.domain.value_objects.MoneyValueObject;

import java.math.BigDecimal;

public final class ShoeVariantPrice extends MoneyValueObject {
    public ShoeVariantPrice(BigDecimal value) {
        super(value);
    }
}
