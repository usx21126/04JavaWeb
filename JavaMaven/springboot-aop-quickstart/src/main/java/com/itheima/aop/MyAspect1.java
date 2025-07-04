package com.itheima.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
@Slf4j
@Aspect
@Component
public class MyAspect1 {
    //抽取公共切入点表达式
//    @Pointcut("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    @Pointcut("@annotation(com.itheima.aop.Log)")
    public void pt(){}
    @Around("pt()")
    public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("环绕前通知");
        Object result = joinPoint.proceed();
        log.info("环绕后通知");
        return result;
    }

    @Before("pt()")
    public void before(JoinPoint joinPoint) {
        log.info("前置通知");
    }

    @After("pt()")
    public void after(JoinPoint joinPoint) {
        log.info("后置通知");
    }

    @AfterReturning("pt()")
    public void afterReturning(JoinPoint joinPoint) {
        log.info("返回后通知");
    }

    @AfterThrowing("pt()")
    public void afterThrowing(JoinPoint joinPoint) {
        log.info("异常后通知");
    }
}
