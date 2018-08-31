package com.cg.website.controller;


import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.cg.website.pojo.Customer;
//import com.google.gson.Gson;

@Controller
public class WebsiteController {
	public static final String url = "http://localhost:8080/customer/";
	
	@RequestMapping("/home")
	public String Home() {
		return "home";
	}
	
	@RequestMapping(value="/viewAllCustomers",method=RequestMethod.GET)
	public String getAllCustomers(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<Customer>> response
		  = restTemplate.exchange("http://localhost:8080/customers", HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>(){});
		
		List<Customer> customers = response.getBody();

		model.addAttribute("customers", customers);
		return "viewAllCustomers";
		
	}
	
	@RequestMapping(value="/customer/{customerId}", method=RequestMethod.GET)
	public String getCustomerById( Model model,@PathVariable int customerId) {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(customerId);
		ResponseEntity<Customer> response
		  = restTemplate.getForEntity(url+customerId, Customer.class);
				
		model.addAttribute("customer", response.getBody());
		return "viewOneCustomer";
	}
	
	/*@RequestMapping(value="/addCustomer",method=RequestMethod.GET)
	public String addCustomer(@RequestBody Customer customer, Model model) {
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Customer> response
		  = restTemplate.exchange("http://localhost:8080/customer/add", HttpMethod.POST, null, new ParameterizedTypeReference<Customer>(){});
		
		//Customer customers = response.

		//model.addAttribute("customers", customers);
		
		return "addNewCustomer";
		
	}*/

}
