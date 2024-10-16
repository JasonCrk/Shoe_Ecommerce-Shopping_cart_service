package com.shoe_ecommerce.shopping_cart.context.cart.application.queries.total_cost;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.UserId;

import com.shoe_ecommerce.shopping_cart.shared.domain.Service;
import com.shoe_ecommerce.shopping_cart.shared.domain.bus.query.QueryHandler;

@Service
public final class CartTotalCostQueryHandler
        implements QueryHandler<CartTotalCostQuery, CartTotalCostResponse> {

    private final CartTotalCostCalculator calculator;

    public CartTotalCostQueryHandler(CartTotalCostCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public CartTotalCostResponse handle(CartTotalCostQuery query) {
        return this.calculator.calculate(new UserId(query.userId()));
    }
}
