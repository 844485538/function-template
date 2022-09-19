package com.lisijing.paramverify.custom.size;

import com.lisijing.paramverify.custom.ListValue;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author 李健新
 * @Date 2022/9/19
 * @Description
 */
public class SizeValidatorForInteger implements ConstraintValidator<Size, Integer> {

    private Integer min;
    private Integer max;

    @Override
    public void initialize(Size constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        int length = value.toString().length();
        if (length > max){
            return false;
        }
        if (length < min){
            return false;
        }
        return true;
    }

}
