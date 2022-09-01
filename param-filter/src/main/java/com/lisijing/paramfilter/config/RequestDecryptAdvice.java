package com.lisijing.paramfilter.config;

import com.alibaba.fastjson.JSONObject;
import com.lisijing.paramfilter.annotations.RequestDecrypt;
import com.lisijing.paramfilter.util.DecryptEncryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

/**
 * @Author 李健新
 * @Date 2022/6/30
 * @Description
 *
 *      对Body内容进行拦截
 */
@ControllerAdvice
public class RequestDecryptAdvice implements RequestBodyAdvice {

    private static final Logger LOG = LoggerFactory.getLogger(RequestDecryptAdvice.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        // 标记此注解的接口，参数先进行解密
        RequestDecrypt annotation = methodParameter.getExecutable().getAnnotation(RequestDecrypt.class);
        return annotation != null;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) throws IOException {
        if (httpInputMessage.getBody().available()<=0) {
            return httpInputMessage;
        }

        // 通过流读取会产生TCP拆包问题
        String data = StreamUtils.copyToString(httpInputMessage.getBody(), Charset.defaultCharset());

        // 使用解密后的数据，构造新的读取流
        InputStream rawInputStream = new ByteArrayInputStream(
                DecryptEncryptUtil.decrypt(JSONObject.parseObject(data).getString("str")).getBytes());
        return new HttpInputMessage() {
            @Override
            public HttpHeaders getHeaders() {
                return httpInputMessage.getHeaders();
            }

            @Override
            public InputStream getBody() throws IOException {
                return rawInputStream;
            }
        };
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return body;
    }

}
