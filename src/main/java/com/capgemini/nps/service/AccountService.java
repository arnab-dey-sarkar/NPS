package com.capgemini.nps.service;

import com.capgemini.nps.entity.Account;

public interface AccountService {

	public Account findAccount(String userName );
	
	public void registerUser(Account account);
}
