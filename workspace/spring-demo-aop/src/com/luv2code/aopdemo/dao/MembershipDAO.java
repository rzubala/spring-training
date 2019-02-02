package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addAccount(int param, AccountInterface account) {
		
		System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
		
		return true;
	}

	public boolean goToSleep() {
		
		System.out.println(getClass() + ": goToSleep()");
		return false;
	}
}
