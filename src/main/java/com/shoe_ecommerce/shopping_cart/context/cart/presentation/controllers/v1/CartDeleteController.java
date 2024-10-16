package com.shoe_ecommerce.shopping_cart.context.cart.presentation.controllers.v1;

import com.shoe_ecommerce.shopping_cart.context.cart.application.commands.empty.EmptyCartCommand;

import com.shoe_ecommerce.shopping_cart.shared.domain.bus.command.CommandBus;
import com.shoe_ecommerce.shopping_cart.shared.domain.bus.query.QueryBus;
import com.shoe_ecommerce.shopping_cart.shared.infrastructure.RestApiController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carts")
public class CartDeleteController extends RestApiController {

    public CartDeleteController(CommandBus commandBus, QueryBus queryBus) {
        super(commandBus, queryBus);
    }

    @DeleteMapping("/empty")
    public ResponseEntity<String> emptyCart(@RequestHeader("X-User-Id") String userId) {
        this.dispatch(new EmptyCartCommand(userId));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
