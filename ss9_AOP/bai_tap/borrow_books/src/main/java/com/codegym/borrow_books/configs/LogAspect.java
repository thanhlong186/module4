package com.codegym.borrow_books.configs;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class LogAspect {
    public static int count = 0;

    @Pointcut("execution(* com.codegym.borrow_books.controller.BookController.*(..))")

    public void allMethodPointCut() {
    }

    @Before("allMethodPointCut()")
    public void beforeCallMethod(JoinPoint joinPoint) {
    String name = joinPoint.getSignature().getName();
        System.out.println("error"+name);
}
    @AfterReturning("allMethodPointCut()")
    public void afterCallMethod(JoinPoint joinPoint) {
        System.out.println(("End method name: "
                + joinPoint.getSignature().getName()
                + "Time: " + LocalDate.now()));
    }
}
