package com.cg.customerproject.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.customerproject.Customer;
import com.cg.customerproject.repository.CustomerRepository;

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

	public Optional<Customer> viewCustomer(int customerId) {
		return repository.findById(customerId);
	}

	
	
}
