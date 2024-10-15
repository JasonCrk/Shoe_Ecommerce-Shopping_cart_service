package com.shoe_ecommerce.shopping_cart.context.cart.infrastructure.persistence;

import com.shoe_ecommerce.shopping_cart.context.cart.domain.Cart;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.value_objects.CartId;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.value_objects.CartTotalCount;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.UserId;

public final class CartMapper {

    public static Cart toEntity(JpaCart cart) {
        return new Cart(
                new CartId(cart.getId().toString()),
                new UserId(cart.getUserId().toString()),
                new CartTotalCount(cart.getTotalCount())
        );
    }

    public static JpaCart toModel(Cart cart) {
        return new JpaCart(
                cart.id().uuid(),
                cart.userId().uuid(),
                cart.totalCount().value()
        );
    }
}
