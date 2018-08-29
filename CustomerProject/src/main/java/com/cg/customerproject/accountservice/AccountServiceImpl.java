package com.cg.customerproject.accountservice;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.customerproject.Customer;
import com.cg.customerproject.account.Account;
import com.cg.customerproject.accountRepo.AccountRepository;

@Component
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepository accRepository;

	@Override
	public Account addAccount(Account account) {
		
		return  accRepository.save(account);
	}

	@Override
	public List<Account> viewAllAccounts() {		
		return accRepository.findAll();
	}

	@Override
	public Account updateAccount(Account account) {
		return accRepository.save(account);
	}

	@Override
	public void deleteAccountById(int accountId) {		
		accRepository.delete(accRepository.findOneByAccountId(accountId));
	}

	@Override
	public Account viewAccount(int accountId) {
		Account account = accRepository.findOneByAccountId(accountId);
		return account;
		
	}

	
	
}
