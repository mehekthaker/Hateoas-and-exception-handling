package com.cg.customerproject.service;



import java.util.List;

import com.cg.customerproject.Customer;

public interface Service {

	public abstract Customer addCustomer(Customer customer);
	public abstract List<Customer> viewAllCustomers();
	public abstract Customer updateCustomer(Customer customer);
	public abstract void deleteCustomer(int customerId);
}
