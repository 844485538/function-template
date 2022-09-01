package com.lisijing.paramfilter.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 李健新
 * @Date 2022/6/30
 * @Description
 *
 *        标记此注解的接口获取参数时先进行解密
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestDecrypt {
}
