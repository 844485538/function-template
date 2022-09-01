package com.lisijing.paramfilter.config;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 方法请求记录
 */
@Aspect
@Component
public class MethodFilter {

    private static final Logger LOG = LoggerFactory.getLogger(MethodFilter.class);

    @Pointcut("execution(public * com.lisijing.paramfilter.controller.*.*(..))")
    public void methodAspect(){}

    @Before(value = "methodAspect()")
    public void methodBefore(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        //打印请求内容
        LOG.info("请求地址：{} - 请求方式：{} - 请求参数：{}" ,
                request.getRequestURL().toString(), request.getMethod(), JSONObject.toJSONString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "o", pointcut = "methodAspect()")
    public void methodAfter(JoinPoint joinPoint, Object o){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        LOG.info("请求地址：{} - 请求方式：{} - 返回数据:{}" ,
                request.getRequestURL().toString(), request.getMethod(), JSONObject.toJSONString(o));
    }

}
