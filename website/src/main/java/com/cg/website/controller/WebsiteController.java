package com.cg.website.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.cg.website.pojo.Customer;
import com.google.gson.Gson;

@Controller
public class WebsiteController {
	
	@RequestMapping("/home")
	public String Home() {
		return "home";
	}
	
	@RequestMapping(value="/viewAllCustomers",method=RequestMethod.GET)
	public String getAllCustomers(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List> response
		  = restTemplate.getForEntity("http://localhost:8080/customers", List.class);
		
		
		Gson gson = new Gson();
 
		String list = gson.toJson(response);
		Customer customer = gson.fromJson(list, Customer.class);
		model.addAttribute("customer",customer);
		return "viewAllCustomers";
		
	}

}
