package com.shoe_ecommerce.shopping_cart.context.shared.domain.exceptions;

import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.value_objects.CartItemCount;

import com.shoe_ecommerce.shopping_cart.shared.domain.exceptions.DomainError;

public class ExcessShoeInventoryStock extends DomainError {
    public ExcessShoeInventoryStock(CartItemCount count) {
        super("excess_shoe_inventory_stock", String.format(
                "The stock on hand exceeds the requested quantity of %d",
                count.value()
        ));
    }
}
