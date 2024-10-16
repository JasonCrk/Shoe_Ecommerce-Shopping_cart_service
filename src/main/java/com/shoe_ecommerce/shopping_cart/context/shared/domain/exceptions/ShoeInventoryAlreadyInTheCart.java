package com.shoe_ecommerce.shopping_cart.context.shared.domain.exceptions;

import com.shoe_ecommerce.shopping_cart.shared.domain.exceptions.DomainError;

public class ShoeInventoryAlreadyInTheCart extends DomainError {
    public ShoeInventoryAlreadyInTheCart() {
        super("shoe_inventory_already_in_the_cart", "The shoe is already in the cart");
    }
}
