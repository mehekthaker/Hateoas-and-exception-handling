package com.cg.customerproject.account;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


public class Account {
	
	@Id
	private ObjectId _id;
	private int accountId;
	private String accountHolderName;
	private String accountType;
	
	
	
	public Account(int accountId, String accountHolderName, String accountType) {
		super();
		
		this.accountId = accountId;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
	}
	
	
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
	@Override
	public String toString() {
		return "Account [_id=" + _id + ", accountId=" + accountId + ", accountHolderName=" + accountHolderName
				+ ", accountType=" + accountType + "]";
	}
	
	
	
	
}
