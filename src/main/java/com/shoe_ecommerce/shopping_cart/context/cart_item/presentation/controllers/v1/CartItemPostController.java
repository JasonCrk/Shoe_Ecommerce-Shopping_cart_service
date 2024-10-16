package com.shoe_ecommerce.shopping_cart.context.cart_item.presentation.controllers.v1;

import com.shoe_ecommerce.shopping_cart.context.cart_item.application.commands.create.CreateCartItemCommand;
import com.shoe_ecommerce.shopping_cart.context.cart_item.presentation.requests.CreateCartItemRequest;

import com.shoe_ecommerce.shopping_cart.shared.domain.UuidGenerator;
import com.shoe_ecommerce.shopping_cart.shared.domain.bus.command.CommandBus;
import com.shoe_ecommerce.shopping_cart.shared.domain.bus.query.QueryBus;
import com.shoe_ecommerce.shopping_cart.shared.infrastructure.RestApiController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Cart items - POSTs")
@RestController
@RequestMapping("/api/v1/cart-items")
public class CartItemPostController extends RestApiController {

    private final UuidGenerator uuidGenerator;

    public CartItemPostController(CommandBus commandBus, QueryBus queryBus, UuidGenerator uuidGenerator) {
        super(commandBus, queryBus);
        this.uuidGenerator = uuidGenerator;
    }

    @Operation(operationId = "Add a cart item in the user cart")
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
