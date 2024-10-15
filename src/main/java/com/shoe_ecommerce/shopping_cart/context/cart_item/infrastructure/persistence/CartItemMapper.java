package com.shoe_ecommerce.shopping_cart.context.cart_item.infrastructure.persistence;

import com.shoe_ecommerce.shopping_cart.context.cart.domain.value_objects.CartId;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.CartItem;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.value_objects.CartItemCount;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.value_objects.CartItemId;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.ShoeInventoryId;

public final class CartItemMapper {

    public static CartItem toEntity(JpaCartItem cartItem) {
        return new CartItem(
                new CartItemId(cartItem.getId().toString()),
                new CartItemCount(cartItem.getCount()),
                new CartId(cartItem.getCartId().toString()),
                new ShoeInventoryId(cartItem.getShoeInventoryId().toString())
        );
    }

    public static JpaCartItem toModel(CartItem cartItem) {
        return new JpaCartItem(
                cartItem.id().uuid(),
                cartItem.cartId().uuid(),
                cartItem.shoeInventoryId().uuid(),
                cartItem.count().value()
        );
    }
}