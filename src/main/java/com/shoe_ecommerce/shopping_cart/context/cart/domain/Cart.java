package com.shoe_ecommerce.shopping_cart.context.cart.domain;

import com.shoe_ecommerce.shopping_cart.context.cart.domain.value_objects.CartId;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.value_objects.CartTotalCount;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.UserId;

import java.util.Objects;

public final class Cart {
    private final CartId id;
    private final UserId userId;
    private CartTotalCount totalCount;

    public Cart(CartId id, UserId userId, CartTotalCount totalCount) {
        this.id = id;
        this.userId = userId;
        this.totalCount = totalCount;
    }

    public static Cart create(CartId id, UserId userId) {
        Cart cart = new Cart(id, userId, new CartTotalCount(0));
        return cart;
    }

    public void incrementTotalCount() {
        totalCount = totalCount.increment();
    }

    public CartId id() {
        return id;
    }

    public UserId userId() {
        return userId;
    }

    public CartTotalCount totalCount() {
        return totalCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;
        return id.equals(cart.id) &&
                userId.equals(cart.userId) &&
                totalCount.equals(cart.totalCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, totalCount);
    }
}
