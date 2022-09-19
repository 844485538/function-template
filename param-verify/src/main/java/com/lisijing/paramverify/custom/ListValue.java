package com.lisijing.paramverify.custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


/**
 * @Author 李健新
 * @Date 2022/9/19
 * @Description
 */
@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
// 指定处理此注解的参数校验器
@Constraint(validatedBy = { ListValueConstraintValidator.class })
public @interface ListValue {

    /**
     * 发生错误是的提示消息
     * @return
     */
    String message() default "{com.lisijing.paramverify.custom.ListValue.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    int[] values() default {};

}
