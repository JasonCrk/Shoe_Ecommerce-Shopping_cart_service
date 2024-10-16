package com.shoe_ecommerce.shopping_cart.context.cart.presentation.controllers.v1;

import com.shoe_ecommerce.shopping_cart.context.cart.application.queries.total_cost.CartTotalCostQuery;
import com.shoe_ecommerce.shopping_cart.context.cart.application.queries.total_cost.CartTotalCostResponse;

import com.shoe_ecommerce.shopping_cart.shared.domain.bus.command.CommandBus;
import com.shoe_ecommerce.shopping_cart.shared.domain.bus.query.QueryBus;
import com.shoe_ecommerce.shopping_cart.shared.domain.bus.query.QueryHandlerExecutionError;
import com.shoe_ecommerce.shopping_cart.shared.infrastructure.RestApiController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/carts")
public class CartGetController extends RestApiController {

    public CartGetController(CommandBus commandBus, QueryBus queryBus) {
        super(commandBus, queryBus);
    }

    @GetMapping("/total")
    public ResponseEntity<HashMap<String, Serializable>> totalPrice(@RequestHeader("X-User-Id") String userId)
            throws QueryHandlerExecutionError {
        CartTotalCostResponse response = (CartTotalCostResponse) this.ask(new CartTotalCostQuery(userId));

        return ResponseEntity.ok().body(
                new HashMap<>() {{
                    put("total_cost", response.total());
                }}
        );
    }
}
