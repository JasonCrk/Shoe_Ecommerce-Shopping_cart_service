package com.shoe_ecommerce.shopping_cart.context.shared.infrastructure.client.mappers;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.entities.ShoeVariant;
import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.*;
import com.shoe_ecommerce.shopping_cart.context.shared.infrastructure.client.model.ClientShoeVariant;

import java.math.BigDecimal;

public final class ShoeVariantMapper {

    public static ShoeVariant toEntity(ClientShoeVariant shoeVariant) {
        return new ShoeVariant(
                new ShoeVariantId(shoeVariant.id()),
                new ShoeVariantName(shoeVariant.name()),
                new ShoeVariantPrice(BigDecimal.valueOf(shoeVariant.price())),
                new ShoeVariantIsDiscontinued(shoeVariant.isDiscontinued()),
                new ShoeModelId(shoeVariant.shoeModelId())
        );
    }
}
