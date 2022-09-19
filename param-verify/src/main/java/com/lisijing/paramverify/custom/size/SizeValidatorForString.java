package com.lisijing.paramverify.custom.size;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author 李健新
 * @Date 2022/9/19
 * @Description
 */
public class SizeValidatorForString implements ConstraintValidator<Size, String> {

    private Integer min;
    private Integer max;

    @Override
    public void initialize(Size constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        int length = value.length();
        if (length > max){
            return false;
        }
        if (length < min){
            return false;
        }
        return true;
    }

}
