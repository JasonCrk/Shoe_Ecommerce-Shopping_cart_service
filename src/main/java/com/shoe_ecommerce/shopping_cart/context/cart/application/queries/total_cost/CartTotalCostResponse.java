package com.shoe_ecommerce.shopping_cart.context.cart.application.queries.total_cost;

import com.shoe_ecommerce.shopping_cart.shared.domain.bus.query.Response;

import java.math.BigDecimal;

public record CartTotalCostResponse(BigDecimal total) implements Response {
}
