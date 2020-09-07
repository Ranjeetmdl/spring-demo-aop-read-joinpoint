package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// read the java config class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		//get the membership bean from the spring container
		MembershipDAO theMembershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
		
		
		//call the businesss method
		Account myAccount = new Account();
		myAccount.setName("Ranjeet");
		myAccount.setLevel("Gold");
		theAccountDAO.addAccount(myAccount,true);
		theAccountDAO.doWork();
		
		//call the getter/setter method on account dao
		theAccountDAO.setName("Ranjeet");
		theAccountDAO.setServiceCode("SER123");
		
		String theName = theAccountDAO.getName();
		String theServiceCode = theAccountDAO.getServiceCode();
		
		//call the business method on membership bean
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
		
		//close the context
		context.close();

	}

}
