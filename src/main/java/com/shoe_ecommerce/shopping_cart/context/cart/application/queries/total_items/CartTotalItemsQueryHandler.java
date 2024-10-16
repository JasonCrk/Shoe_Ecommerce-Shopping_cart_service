package com.shoe_ecommerce.shopping_cart.context.cart.application.queries.total_items;

import com.shoe_ecommerce.shopping_cart.context.cart.domain.Cart;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.exceptions.UserDoesNotHaveCart;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.ports.repositories.CartRepository;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.UserId;

import com.shoe_ecommerce.shopping_cart.shared.domain.Service;
import com.shoe_ecommerce.shopping_cart.shared.domain.bus.query.QueryHandler;

@Service
public class CartTotalItemsQueryHandler implements QueryHandler<CartTotalItemsQuery, CartTotalItemsResponse> {

    private final CartRepository cartRepository;

    public CartTotalItemsQueryHandler(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public CartTotalItemsResponse handle(CartTotalItemsQuery query) {
        Cart cart = cartRepository.findByUserId(new UserId(query.userId())).orElseThrow(UserDoesNotHaveCart::new);

        return new CartTotalItemsResponse(cart.totalCount().value());
    }
}
