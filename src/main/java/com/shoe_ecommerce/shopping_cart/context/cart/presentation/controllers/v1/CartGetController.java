package com.shoe_ecommerce.shopping_cart.context.cart.presentation.controllers.v1;

import com.shoe_ecommerce.shopping_cart.context.cart.application.queries.total_cost.CartTotalCostQuery;
import com.shoe_ecommerce.shopping_cart.context.cart.application.queries.total_cost.CartTotalCostResponse;
import com.shoe_ecommerce.shopping_cart.context.cart.application.queries.total_items.CartTotalItemsQuery;
import com.shoe_ecommerce.shopping_cart.context.cart.application.queries.total_items.CartTotalItemsResponse;

import com.shoe_ecommerce.shopping_cart.shared.domain.bus.command.CommandBus;
import com.shoe_ecommerce.shopping_cart.shared.domain.bus.query.QueryBus;
import com.shoe_ecommerce.shopping_cart.shared.domain.bus.query.QueryHandlerExecutionError;
import com.shoe_ecommerce.shopping_cart.shared.infrastructure.RestApiController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;

@Tag(name = "Cart - GETs")
@RestController
@RequestMapping("/api/v1/carts")
public class CartGetController extends RestApiController {

    public CartGetController(CommandBus commandBus, QueryBus queryBus) {
        super(commandBus, queryBus);
    }

    @Operation(operationId = "Get total cost of the items in the user cart")
    @GetMapping("/total-cost")
    public ResponseEntity<HashMap<String, Serializable>> totalCost(@RequestHeader("X-User-Id") String userId)
            throws QueryHandlerExecutionError {
        CartTotalCostResponse response = (CartTotalCostResponse) this.ask(new CartTotalCostQuery(userId));

        return ResponseEntity.ok().body(
                new HashMap<>() {{
                    put("total_cost", response.total());
                }}
        );
    }

    @Operation(operationId = "Get total items in the user cart")
    @GetMapping("/total-items")
    public ResponseEntity<HashMap<String, Serializable>> totalItems(@RequestHeader("X-User-Id") String userId)
            throws QueryHandlerExecutionError {
        CartTotalItemsResponse response = (CartTotalItemsResponse) this.ask(new CartTotalItemsQuery(userId));

        return ResponseEntity.ok().body(
                new HashMap<>() {{
                    put("total_items", response.totalItems());
                }}
        );
    }
}
