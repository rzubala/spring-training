package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advises for logging
	
	// let's start with an @Before advice

	//@Before("execution(public void addAccount())")
	//@Before("execution(* *Account())")
	//@Before("execution(* com.luv2code.aopdemo.dao.Account.*Account())")
	//@Before("execution(* add*(..))")
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void beforeAddAllAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on ALL addAccount()");
		
	}

	@Before("execution(* com.luv2code.aopdemo.dao.*.*(com.luv2code.aopdemo.Account, ..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
		
	}
}










