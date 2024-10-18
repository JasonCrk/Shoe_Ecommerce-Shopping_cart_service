package com.shoe_ecommerce.shopping_cart.context.cart_item.application.events.remove_by_shoe_model;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.ShoeModelId;

import com.shoe_ecommerce.shopping_cart.shared.domain.Service;
import com.shoe_ecommerce.shopping_cart.shared.domain.bus.event.DomainEventSubscriber;
import com.shoe_ecommerce.shopping_cart.shared.domain.domain_events.shoe_model.ShoeModelDiscontinuedDomainEvent;

import org.springframework.context.event.EventListener;

@Service
@DomainEventSubscriber(ShoeModelDiscontinuedDomainEvent.class)
public class RemoveAllCartItemsWhichShoeModelIsDiscontinued {
    private final CartItemRemoverByShoeModel remover;

    public RemoveAllCartItemsWhichShoeModelIsDiscontinued(CartItemRemoverByShoeModel remover) {
        this.remover = remover;
    }

    @EventListener
    public void on(ShoeModelDiscontinuedDomainEvent event) {
        ShoeModelId shoeModelId = new ShoeModelId(event.aggregateId());

        remover.removeAllByShoeModel(shoeModelId);
    }
}
