package com.cg.customerproject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Satyen Singh
 *
 *Maintaining customer details of money money bank
 */
@XmlRootElement
@Entity
public class Customer{
	@Id
	private int customerId;
	private String customerName;
	private long contactNumber;
	private String emailId;
	private String dateOfBirth;
	//private String url;

	/*private static int custId;
	
	static {
		custId = 200;
	}
	
	this.customerId = custId;*/
	
	
		
	public Customer(int customerId, String customerName, long contactNumber, String dateOfBirth, String email) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.dateOfBirth = dateOfBirth;
		this.emailId = email;
		//this.url = url;
	}
	
	public Customer() {
		
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

		
/*	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}*/
	

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", contactNumber="
				+ contactNumber + ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + "]";
	}


	
}
