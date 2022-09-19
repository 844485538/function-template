package com.lisijing.paramverify.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author 李健新
 * @Date 2020/11/4
 * @Description
 *
 *      统一异常处理类
 */
@RestControllerAdvice
public class AllExceptionHandler {

    /**
     * 处理 JSR - 303 参数异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseTemplate checkParamException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        return ResponseTemplate.paramErrorException(bindingResult.getFieldErrors().get(0).getDefaultMessage());
    }

    /**
     * 系统抛出的异常处理
     *
     */
    @ExceptionHandler()
    public ResponseTemplate osRuntimeException(RuntimeException e) {
        e.printStackTrace();
        return ResponseTemplate.fail();
    }

}
