package com.lisijing.paramverify.custom.size;

import com.lisijing.paramverify.custom.ListValueConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
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
@Constraint(validatedBy = { SizeValidatorForString.class, SizeValidatorForInteger.class })
public @interface Size {

    /**
     * 发生错误是的提示消息
     * @return
     */
    String message() default "{com.lisijing.paramverify.custom.Size.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    /**
     * @return size the element must be higher or equal to
     */
    int min() default 0;

    /**
     * @return size the element must be lower or equal to
     */
    int max() default Integer.MAX_VALUE;

}
