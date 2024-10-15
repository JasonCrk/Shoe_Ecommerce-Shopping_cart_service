package com.shoe_ecommerce.shopping_cart.shared.domain.bus.query;

public class QueryNotRegisteredError extends Exception {
    public QueryNotRegisteredError(Class<? extends Query> query) {
        super(String.format("The query <%s> hasn't a query handler associated", query.getName()));
    }
}
