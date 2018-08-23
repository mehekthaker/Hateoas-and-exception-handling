package com.cg.customers.controller;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.customers.Customer;
import com.cg.customers.service.ServiceImpl;

@RestController
public class CustomerController {
	
	@Autowired
	private ServiceImpl service; 
	
	
	
	@RequestMapping(value="/customer/add", method=RequestMethod.POST, consumes="application/json")
	public void addCustomer(@RequestBody Customer customer) {
		System.out.println(service);
		service.addCustomer(customer);
	}
	
	@RequestMapping(value="/customers", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public Collection<Customer> viewAllCustomers() {
		return service.viewAllCustomers();
		
	}
	
	@RequestMapping(value="/customer/update", method=RequestMethod.PUT, consumes="application/json")
	public void updateCustomer(@RequestBody Customer customer) {
		service.updateCustomer(customer);
	}
	
	@RequestMapping(value="/customer/delete", method=RequestMethod.DELETE)
	public void deleteCustomer(int customerId) {
		service.deleteCustomer(customerId);
		//return new ResponseEntity<String>("Deleted entity", new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/customer/{start}/{count}", method=RequestMethod.GET)
	public Resources getCustomersByPages(@PathVariable int start, @PathVariable int count) {
		List<Customer> tempCustomers = service.viewAllCustomers();
		List<Customer> customers = new ArrayList<>();
		//Resources<List<Customer>> resources = null;
		for(int i = start; i<start+count; i++) {
			customers.add(tempCustomers.get(i));
		}
	
		Link nextLink = linkTo(methodOn(this.getClass()).getCustomersByPages(start+count, count)).withRel("Next Link");
		Link previousLink = linkTo(methodOn(this.getClass()).getCustomersByPages(start-count>=0?start-count:1, count)).withRel("Previous Link");
		
		return new Resources<>(customers,nextLink,previousLink); 
		
	}
	
	/*@RequestMapping(value="/getById", method=RequestMethod.GET)
	public Resource<Customer> getById(int customerId){
		Resource<Customer> resource = null;
		for(Customer customer: service.viewAllCustomers()) {
			if(customer.getCustomerId() == customerId) {
				resource = new Resource<Customer>(customer);
			break;
			}
		}
		ControllerLinkBuilder link = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).viewAllCustomers());
		resource.add(link.withRel("All-Customers"));
		resource.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).deleteCustomer(customerId)).withRel("Update-this-customer"));
		return resource;
		
	}
*/
}
