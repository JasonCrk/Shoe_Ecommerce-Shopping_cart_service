package com.shoe_ecommerce.shopping_cart.context.cart.application.queries.total_cost;

import com.shoe_ecommerce.shopping_cart.shared.domain.bus.query.Query;

public record CartTotalCostQuery(String userId) implements Query {
}
