package com.shoe_ecommerce.shopping_cart.context.cart.presentation.controllers.v1;

import com.shoe_ecommerce.shopping_cart.context.cart.application.commands.empty.EmptyCartCommand;

import com.shoe_ecommerce.shopping_cart.shared.domain.bus.command.CommandBus;
import com.shoe_ecommerce.shopping_cart.shared.domain.bus.query.QueryBus;
import com.shoe_ecommerce.shopping_cart.shared.infrastructure.RestApiController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Cart - DELETEs")
@RestController
@RequestMapping("/api/v1/carts")
public class CartDeleteController extends RestApiController {

    public CartDeleteController(CommandBus commandBus, QueryBus queryBus) {
        super(commandBus, queryBus);
    }

    @Operation(operationId = "Delete cart items from cart")
    @DeleteMapping("/empty")
    public ResponseEntity<String> emptyCart(@RequestHeader("X-User-Id") String userId) {
        this.dispatch(new EmptyCartCommand(userId));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
