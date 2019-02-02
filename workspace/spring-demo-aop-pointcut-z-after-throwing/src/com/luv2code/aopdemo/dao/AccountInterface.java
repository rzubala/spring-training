package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;

public interface AccountInterface {
	public void addAccount(Account theAccount, boolean vip);

	public boolean doWork();
}
