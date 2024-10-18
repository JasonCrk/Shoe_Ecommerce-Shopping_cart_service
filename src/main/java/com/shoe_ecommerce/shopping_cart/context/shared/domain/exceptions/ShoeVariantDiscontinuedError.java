package com.shoe_ecommerce.shopping_cart.context.shared.domain.exceptions;

import com.shoe_ecommerce.shopping_cart.context.shared.domain.value_objects.ShoeVariantId;

import com.shoe_ecommerce.shopping_cart.shared.domain.exceptions.DomainError;

public class ShoeVariantDiscontinuedError extends DomainError {
    public ShoeVariantDiscontinuedError(ShoeVariantId id) {
        super("shoe_variant_discontinued", String.format(
                "The shoe variant <%s> is discontinued",
                id.value()
        ));
    }
}
