package com.jumia.jpay.customers.service.core.domain.validators;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class CustomValidator {

    private CustomValidator() {
        throw new IllegalStateException("Custom Validator");
    }

    public static void validateAndThrow(Object obj) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        var validator = factory.getValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(obj);

        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }
}