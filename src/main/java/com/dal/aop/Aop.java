package com.dal.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Aop {
	
	@Around("execution(* com.dal.service..join*(..))")
	public Object dalAop(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("dalAop : Advice 실행함 joinPoint 실행이전");
		Object obj = null;
		
		try {
			System.out.println("advice 실행함");
			obj = joinPoint.proceed();
			
		}finally {
			System.out.println("joinPoint 실행이후");
		}
		
		return obj;
	}
	
}
