package com.spring.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	@Pointcut("execution(* com.spring.biz..DaoImpl.*(..))")
	public void allPointcut() {}
	@Before("allPointcut()")
	public void printLogReturning() {
		System.out.println("[Returning]...");
	}
	@After("allPointcut()")
	public void printLogAfter() {
		System.out.println("[After]...");
	}
}
