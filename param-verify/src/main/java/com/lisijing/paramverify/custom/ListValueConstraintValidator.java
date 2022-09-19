package com.lisijing.paramverify.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author 李健新
 * @Date 2022/9/19
 * @Description
 *
 *      ConstraintValidator<SelectListValues, Integer>，第一个类型时对应绑定的注解，第二个类型对应的时修饰的参数类型；
 */
public class ListValueConstraintValidator implements ConstraintValidator<ListValue,Integer> {


    private Set<Integer> set=new HashSet<Integer>();

    /**
     * 初始化方法
     *
     *  可以从这里拿到用户使用注解的一些信息，比如参数值；
     *
     * @param constraintAnnotation
     */
    @Override
    public void initialize(ListValue constraintAnnotation) {
        int[] value = constraintAnnotation.values();
        for (int i : value) {
            set.add(i);
        }
    }

    /**
     * 校验方法
     *
     *      可以获得用户实际传递的值，可以在此处进行校验，如果通过返回true，否则返回false
     * @param value  需要校验的值
     * @param context
     * @return
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return set.contains(value);
    }

}
