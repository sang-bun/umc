package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.PageValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPage {
    String message() default "VALID_PAGE_NEGATIVE";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}