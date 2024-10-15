package com.shoe_ecommerce.shopping_cart.shared.infrastructure;

import com.shoe_ecommerce.shopping_cart.shared.domain.Service;
import com.shoe_ecommerce.shopping_cart.shared.domain.UuidGenerator;

import java.util.UUID;

@Service
public final class JavaUuidGenerator implements UuidGenerator {

    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
