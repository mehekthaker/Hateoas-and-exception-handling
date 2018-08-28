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

	public Customer addCustomer(Customer customer) {		
		return repository.save(customer);
	}

	public List<Customer> viewAllCustomers() {
		return repository.findAll();
	}


	public Customer updateCustomer(Customer customer) {
		return repository.save(customer);
	}

	public void deleteCustomer(int customerId) {
		System.out.println(repository.findById(customerId));
		repository.deleteById(customerId);
		
	}

	public Optional<Customer> viewCustomer(int customerId) {
		return repository.findById(customerId);
	}

	
	
}
