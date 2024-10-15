package com.shoe_ecommerce.shopping_cart.shared.presentation.validations.is_uuid;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.METHOD})
@Constraint(validatedBy = IsUuidValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IsUuid {
    String message() default "Is invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
