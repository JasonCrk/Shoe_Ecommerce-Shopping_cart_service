package com.shoe_ecommerce.shopping_cart.context.cart.application.queries.total_items;

import com.shoe_ecommerce.shopping_cart.shared.domain.bus.query.Response;

public record CartTotalItemsResponse(int totalItems) implements Response {
}
