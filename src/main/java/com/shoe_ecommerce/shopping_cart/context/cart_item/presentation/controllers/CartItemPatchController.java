package com.shoe_ecommerce.shopping_cart.context.cart_item.presentation.controllers;

import com.shoe_ecommerce.shopping_cart.context.cart_item.application.commands.update_count.UpdateCartItemCountCommand;
import com.shoe_ecommerce.shopping_cart.context.cart_item.presentation.requests.UpdateCartItemCountRequest;

import com.shoe_ecommerce.shopping_cart.shared.domain.bus.command.CommandBus;
import com.shoe_ecommerce.shopping_cart.shared.domain.bus.query.QueryBus;
import com.shoe_ecommerce.shopping_cart.shared.infrastructure.RestApiController;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cart-items")
public class CartItemPatchController extends RestApiController {

    public CartItemPatchController(CommandBus commandBus, QueryBus queryBus) {
        super(commandBus, queryBus);
    }

    @PatchMapping("/{id}/count")
    public ResponseEntity<String> updateCount(
            @PathVariable("id") UUID cartItemId,
            @Valid @RequestBody UpdateCartItemCountRequest request,
            @RequestHeader("X-User-Id") String userId
    ) {
        this.dispatch(new UpdateCartItemCountCommand(
                cartItemId.toString(),
                request.count(),
                userId
        ));

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
