package com.cg.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.customers.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
