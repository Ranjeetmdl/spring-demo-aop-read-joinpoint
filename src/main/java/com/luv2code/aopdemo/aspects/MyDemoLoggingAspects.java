package com.luv2code.aopdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspects {
	
	@Before("com.luv2code.aopdemo.aspects.LuvAOPExpression.forDaoPackageExcludeGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
		System.out.println("\n====>Executing @Before advice on method()");
		
		//display the method signature
		MethodSignature methodSign = (MethodSignature)theJoinPoint.getSignature();
		System.out.println("Method :"+methodSign);
		
		//display the method parameters
		Object[] args = theJoinPoint.getArgs();
		for(Object tempArg : args){
			System.out.println(tempArg);
			
			if(tempArg instanceof Account){
				//downcast and print account specific info
				Account theAccount=(Account) tempArg;
				System.out.println("Account Name :"+theAccount.getName());
				System.out.println("Account Level :"+theAccount.getLevel());
			}
		}
	}
	
}
