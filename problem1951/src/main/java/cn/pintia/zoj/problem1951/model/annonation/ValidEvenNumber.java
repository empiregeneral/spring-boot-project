package cn.pintia.zoj.problem1951.model.annonation;

import cn.pintia.zoj.problem1951.model.validation.ValidEvenNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidEvenNumberValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEvenNumber {
    String message() default "Must be an even number greater than or equal to 6";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
