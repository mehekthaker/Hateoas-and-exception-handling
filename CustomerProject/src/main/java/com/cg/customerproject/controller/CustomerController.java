package com.cg.customerproject.controller;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.customerproject.Customer;
import com.cg.customerproject.service.ServiceImpl;

@RestController
public class CustomerController {
	
	@Autowired
	private ServiceImpl service; 
	
	
	
	@RequestMapping(value="/customer/add", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		//System.out.println(service);
		/*service.addCustomer(customer);*/
		return new ResponseEntity<Customer>(service.addCustomer(customer), HttpStatus.OK);
	}
	
	@RequestMapping(value="/customers", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public ResponseEntity<List<Customer>> viewAllCustomers() {
		System.out.println(service.viewAllCustomers());
		return new ResponseEntity<List<Customer>>(service.viewAllCustomers(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/customer/update", method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		//service.updateCustomer(customer);
		return new ResponseEntity<Customer>(service.updateCustomer(customer), HttpStatus.OK);
	}
	
	@RequestMapping(value="/customer/delete/{customerId}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteCustomer(@PathVariable int customerId) {
		service.deleteCustomer(customerId);
		
		return new ResponseEntity<String>("Entity Deleted",HttpStatus.OK);
	}
	
	@RequestMapping(value="/customer/{start}/{count}", method=RequestMethod.GET)
	public ResponseEntity<Resources> getCustomersByPages(@PathVariable int start, @PathVariable int count) {
		List<Customer> tempCustomers = service.viewAllCustomers();
		List<Customer> customers = new ArrayList<>();
		//Resources<List<Customer>> resources = null;
		for(int i = start; i<start+count; i++) {
			customers.add(tempCustomers.get(i));
		}
	
		Link nextLink = linkTo(methodOn(this.getClass()).getCustomersByPages(start+count>tempCustomers.size()-count?tempCustomers.size()-count+1:start+count, count)).withRel("Next Link");
		Link previousLink = linkTo(methodOn(this.getClass()).getCustomersByPages(start-count>=0?start-count:1, count)).withRel("Previous Link");
		Resources resources = new Resources<>(customers,nextLink,previousLink);
		return new ResponseEntity<Resources>(resources, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/customer/{customerId}", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public Resource<Customer> viewCustomer(@PathVariable int customerId) {
		Link link = linkTo(methodOn(this.getClass()).viewAllCustomers()).withRel("View Customers");
		return new Resource(service.viewCustomer(customerId), link);
		
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
		ControllerLinkBuilder link = linkTo(methodOn(this.getClass()).viewAllCustomers());
		resource.add(link.withRel("View-All-Customers"));
  		//resource.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).deleteCustomer(customerId)).withRel("Update-this-customer"));
 
  		return resource;
 
		
	}*/

}
