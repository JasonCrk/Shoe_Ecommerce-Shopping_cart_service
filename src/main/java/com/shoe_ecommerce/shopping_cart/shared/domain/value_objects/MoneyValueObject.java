package com.shoe_ecommerce.shopping_cart.shared.domain.value_objects;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class MoneyValueObject {
    private final BigDecimal value;

    public MoneyValueObject(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal value() {
        return this.value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;

        if (object == null || getClass() != object.getClass()) return false;

        MoneyValueObject that = (MoneyValueObject) object;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
