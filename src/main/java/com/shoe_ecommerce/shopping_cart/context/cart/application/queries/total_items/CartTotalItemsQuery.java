package com.shoe_ecommerce.shopping_cart.context.cart.application.queries.total_items;

import com.shoe_ecommerce.shopping_cart.shared.domain.bus.query.Query;

public record CartTotalItemsQuery(String userId) implements Query {
}
