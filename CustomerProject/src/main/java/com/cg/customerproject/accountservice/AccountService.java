package com.cg.customerproject.accountservice;

import java.util.List;



import com.cg.customerproject.account.Account;

public interface AccountService {

	public abstract Account addAccount(Account account);
	public abstract List<Account> viewAllAccounts();
	public abstract Account updateAccount(Account account);
	public abstract void deleteAccountById(int accountId);
	public abstract Account viewAccount(int accountId);
	
}
