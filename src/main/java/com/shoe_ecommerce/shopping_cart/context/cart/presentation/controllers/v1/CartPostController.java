package com.shoe_ecommerce.shopping_cart.context.cart.presentation.controllers.v1;

import com.shoe_ecommerce.shopping_cart.context.cart.application.commands.create.CreateCartCommand;
import com.shoe_ecommerce.shopping_cart.context.cart.presentation.requests.CreateCartRequest;

import com.shoe_ecommerce.shopping_cart.shared.domain.UuidGenerator;
import com.shoe_ecommerce.shopping_cart.shared.domain.bus.command.CommandBus;
import com.shoe_ecommerce.shopping_cart.shared.domain.bus.query.QueryBus;
import com.shoe_ecommerce.shopping_cart.shared.infrastructure.RestApiController;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/carts")
public class CartPostController extends RestApiController {

    private final UuidGenerator uuidGenerator;

    public CartPostController(CommandBus commandBus, QueryBus queryBus, UuidGenerator uuidGenerator) {
        super(commandBus, queryBus);
        this.uuidGenerator = uuidGenerator;
    }

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody CreateCartRequest request) {
        this.dispatch(new CreateCartCommand(uuidGenerator.generate(), request.userId()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
