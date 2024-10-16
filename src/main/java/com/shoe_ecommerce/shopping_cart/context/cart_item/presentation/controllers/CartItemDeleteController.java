package com.shoe_ecommerce.shopping_cart.context.cart_item.presentation.controllers;

import com.shoe_ecommerce.shopping_cart.context.cart_item.application.commands.remove.RemoveCartItemCommand;

import com.shoe_ecommerce.shopping_cart.shared.domain.bus.command.CommandBus;
import com.shoe_ecommerce.shopping_cart.shared.domain.bus.query.QueryBus;
import com.shoe_ecommerce.shopping_cart.shared.infrastructure.RestApiController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cart-items")
public class CartItemDeleteController extends RestApiController {

    public CartItemDeleteController(CommandBus commandBus, QueryBus queryBus) {
        super(commandBus, queryBus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remove(
            @PathVariable("id") UUID cartItemId,
            @RequestHeader("X-User-Id") String userId
    ) {
        this.dispatch(new RemoveCartItemCommand(cartItemId.toString(), userId));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
