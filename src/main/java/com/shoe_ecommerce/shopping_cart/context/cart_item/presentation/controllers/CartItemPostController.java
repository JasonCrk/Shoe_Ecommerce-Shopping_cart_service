package com.shoe_ecommerce.shopping_cart.context.cart_item.presentation.controllers;

import com.shoe_ecommerce.shopping_cart.context.cart_item.application.commands.create.CreateCartItemCommand;
import com.shoe_ecommerce.shopping_cart.context.cart_item.presentation.requests.CreateCartItemRequest;

import com.shoe_ecommerce.shopping_cart.shared.domain.UuidGenerator;
import com.shoe_ecommerce.shopping_cart.shared.domain.bus.command.CommandBus;
import com.shoe_ecommerce.shopping_cart.shared.domain.bus.query.QueryBus;
import com.shoe_ecommerce.shopping_cart.shared.infrastructure.RestApiController;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart-items")
public class CartItemPostController extends RestApiController {

    private final UuidGenerator uuidGenerator;

    public CartItemPostController(CommandBus commandBus, QueryBus queryBus, UuidGenerator uuidGenerator) {
        super(commandBus, queryBus);
        this.uuidGenerator = uuidGenerator;
    }

    @PostMapping
    public ResponseEntity<String> create(
            @RequestHeader("X-User-Id") String userId,
            @Valid @RequestBody CreateCartItemRequest request
    ) {
        this.dispatch(new CreateCartItemCommand(
                uuidGenerator.generate(),
                request.shoeInventoryId(),
                request.count(),
                userId
        ));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
