package com.codegym.borrow_books.configs;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    public static int count = 0;

    
}
