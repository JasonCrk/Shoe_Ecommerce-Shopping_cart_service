package com.shoe_ecommerce.shopping_cart.context.cart_item.application.commands.update_count;

import com.shoe_ecommerce.shopping_cart.context.cart.domain.exceptions.IsNotOwnerOfCart;
import com.shoe_ecommerce.shopping_cart.context.cart.domain.ports.repositories.CartRepository;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.CartItem;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.exceptions.CartItemNotExist;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.ports.repositories.CartItemRepository;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.value_objects.CartItemCount;
import com.shoe_ecommerce.shopping_cart.context.cart_item.domain.value_objects.CartItemId;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.entities.ShoeInventory;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.exceptions.ExcessShoeInventoryStock;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.ports.services.ShoeInventoryService;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.UserId;

import com.shoe_ecommerce.shopping_cart.shared.domain.Service;

@Service
public final class UpdateCartItemCount {

    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;

    private final ShoeInventoryService shoeInventoryService;

    public UpdateCartItemCount(
            CartItemRepository cartItemRepository,
            CartRepository cartRepository,
            ShoeInventoryService shoeInventoryService
    ) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.shoeInventoryService = shoeInventoryService;
    }

    public void update(CartItemId cartItemId, CartItemCount count, UserId userId) {
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new CartItemNotExist(cartItemId));

        boolean userIsNotOwnerOfCart = cartRepository.existsByIdAndUserId(cartItem.cartId(), userId);

        if (userIsNotOwnerOfCart) throw new IsNotOwnerOfCart();

        ShoeInventory shoeInventory = shoeInventoryService.getById(cartItem.shoeInventoryId());

        if (count.value() > shoeInventory.stock().value()) throw new ExcessShoeInventoryStock(count);

        cartItem.updateCount(count);

        cartItemRepository.save(cartItem);
    }
}
