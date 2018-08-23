package com.cg.customers.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.customers.Customer;
import com.cg.customers.repository.CustomerRepository;

@Component
public class ServiceImpl implements Service{
	
	@Autowired
	CustomerRepository repository;

	public void addCustomer(Customer customer) {		
		repository.save(customer);
	}

	public List<Customer> viewAllCustomers() {
		return repository.findAll();
	}


	public void updateCustomer(Customer customer) {
		repository.save(customer);
	}

	public void deleteCustomer(int customerId) {
		repository.deleteById(customerId);
		
	}

	
	
}
