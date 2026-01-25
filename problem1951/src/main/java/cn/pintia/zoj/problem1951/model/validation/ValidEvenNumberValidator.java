package cn.pintia.zoj.problem1951.model.validation;

import cn.pintia.zoj.problem1951.model.annonation.ValidEvenNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidEvenNumberValidator implements ConstraintValidator<ValidEvenNumber, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null){
            return false;
        }
        return value >=6 && value % 2 == 0;
    }
}
