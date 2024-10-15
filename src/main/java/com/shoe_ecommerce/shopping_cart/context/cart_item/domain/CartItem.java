package com.shoe_ecommerce.shopping_cart.context.cart_item.domain;

import com.shoe_ecommerce.shopping_cart.context.cart.domain.value_objects.CartId;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.value_objects.CartItemCount;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.value_objects.CartItemId;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.ShoeInventoryId;

import java.util.Objects;

public final class CartItem {
    private final CartItemId id;
    private final CartItemCount count;
    private final CartId cartId;
    private final ShoeInventoryId shoeInventoryId;

    public CartItem(CartItemId id, CartItemCount count, CartId cartId, ShoeInventoryId shoeInventoryId) {
        this.id = id;
        this.count = count;
        this.cartId = cartId;
        this.shoeInventoryId = shoeInventoryId;
    }

    public CartItemId id() {
        return id;
    }

    public CartItemCount count() {
        return count;
    }

    public CartId cartId() {
        return cartId;
    }

    public ShoeInventoryId shoeInventoryId() {
        return shoeInventoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CartItem cartItem = (CartItem) o;
        return id.equals(cartItem.id) &&
                count.equals(cartItem.count) &&
                cartId.equals(cartItem.cartId) &&
                shoeInventoryId.equals(cartItem.shoeInventoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, count, cartId, shoeInventoryId);
    }
}
