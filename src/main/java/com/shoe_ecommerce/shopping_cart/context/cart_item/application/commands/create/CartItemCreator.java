package com.shoe_ecommerce.shopping_cart.context.cart_item.application.commands.create;

import com.shoe_ecommerce.shopping_cart.context.cart.domain.Cart;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.exceptions.UserDoesNotHaveCart;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.ports.repositories.CartRepository;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.CartItem;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.ports.repositories.CartItemRepository;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.value_objects.CartItemCount;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.value_objects.CartItemId;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.entities.ShoeInventory;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.exceptions.ExcessShoeInventoryStock;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.exceptions.ShoeInventoryAlreadyInTheCart;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.ports.services.ShoeInventoryService;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.ShoeInventoryId;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.UserId;

import com.shoe_ecommerce.shopping_cart.shared.domain.Service;

@Service
public final class CartItemCreator {

    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;

    private final ShoeInventoryService shoeInventoryService;

    public CartItemCreator(
            CartItemRepository cartItemRepository,
            CartRepository cartRepository,
            ShoeInventoryService shoeInventoryService
    ) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.shoeInventoryService = shoeInventoryService;
    }

    public void create(
            CartItemId id,
            CartItemCount count,
            ShoeInventoryId shoeInventoryId,
            UserId userId
    ) {
        ShoeInventory shoeInventory = shoeInventoryService.getById(shoeInventoryId);

        if (count.value() > shoeInventory.stock().value())
            throw new ExcessShoeInventoryStock(count);

        Cart cart = cartRepository.findByUserId(userId).orElseThrow(UserDoesNotHaveCart::new);

        boolean shoeInventoryAlreadyInTheCart = cartItemRepository
                .existsByCartIdAndShoeInventoryId(cart.id(), shoeInventoryId);

        if (shoeInventoryAlreadyInTheCart) throw new ShoeInventoryAlreadyInTheCart();

        CartItem cartItem = CartItem.create(
                id,
                count,
                cart.id(),
                shoeInventory.id(),
                shoeInventory.variant().id(),
                shoeInventory.variant().modelId()
        );

        cartItemRepository.save(cartItem);

        cart.incrementTotalCount();
        cartRepository.save(cart);
    }
}
