package com.lisijing.paramfilter.config;

import com.lisijing.paramfilter.annotations.ResponseEncrypt;
import com.lisijing.paramfilter.util.DecryptEncryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Author 李健新
 * @Date 2022/6/29
 * @Description
 *
 *      返回值加密
 *
 */
@ControllerAdvice
public class ResponseEncryptAdvice implements ResponseBodyAdvice<Object> {

    private static final Logger LOG = LoggerFactory.getLogger(ResponseEncryptAdvice.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        // 标记此注解的接口，返回值进行加密
        ResponseEncrypt annotation = methodParameter.getExecutable().getAnnotation(ResponseEncrypt.class);
        return annotation != null;
    }

    @Override
    public String beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        serverHttpResponse.getHeaders().setContentType(MediaType.parseMediaType(MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8"));
        String result =  DecryptEncryptUtil.encrypt(String.valueOf(o));
        return result;
    }

}
