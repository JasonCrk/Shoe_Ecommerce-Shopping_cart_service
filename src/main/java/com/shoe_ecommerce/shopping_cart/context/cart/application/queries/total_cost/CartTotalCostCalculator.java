package com.shoe_ecommerce.shopping_cart.context.cart.application.queries.total_cost;

import com.shoe_ecommerce.shopping_cart.context.cart.domain.Cart;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.exceptions.UserDoesNotHaveCart;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.ports.repositories.CartRepository;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.CartItem;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.ports.repositories.CartItemRepository;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.entities.ShoeInventory;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.ports.services.ShoeInventoryService;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.UserId;

import com.shoe_ecommerce.shopping_cart.shared.domain.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public final class CartTotalCostCalculator {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    private final ShoeInventoryService shoeInventoryService;

    public CartTotalCostCalculator(
            CartRepository cartRepository,
            CartItemRepository cartItemRepository,
            ShoeInventoryService shoeInventoryService
    ) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.shoeInventoryService = shoeInventoryService;
    }

    public CartTotalCostResponse calculate(UserId userId) {
        Cart cart = cartRepository.findByUserId(userId).orElseThrow(UserDoesNotHaveCart::new);

        List<CartItem> cartItems = cartItemRepository.findAllByCartId(cart.id());

        BigDecimal totalPrice = BigDecimal.ZERO;

        for (CartItem cartItem : cartItems) {
            ShoeInventory shoeInventory = shoeInventoryService.getById(cartItem.shoeInventoryId());

            BigDecimal cartItemTotal = shoeInventory.variant().price().value()
                    .multiply(BigDecimal.valueOf(cartItem.count().value()));

            totalPrice = totalPrice.add(cartItemTotal);
        }

        return new CartTotalCostResponse(totalPrice);
    }
}
