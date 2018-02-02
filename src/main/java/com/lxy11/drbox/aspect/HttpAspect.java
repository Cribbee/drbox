package com.lxy11.drbox.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class HttpAspect {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.lxy11.drbox.action.GoodsController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}", request.getRequestURI());

        //session
        logger.info("session={}",request.getSession());

       //cookies
      logger.info("cookies={}",request.getCookies().toString());

        //request method
        logger.info("request method={}",request.getMethod());

        //ip
        logger.info("ip={}",request.getRemoteAddr());

        //class_method
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //args
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturing(Object object){
        logger.info("response={}",object);
    }
}
