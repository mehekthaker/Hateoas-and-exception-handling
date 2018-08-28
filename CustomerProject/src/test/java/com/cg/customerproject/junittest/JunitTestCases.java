package com.cg.customerproject.junittest;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cg.customerproject.Customer;




@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)


public class JunitTestCases {

//	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;
	
	
	TestRestTemplate testRestTemplate = new TestRestTemplate();
	
	@Before
	public void setUp() {
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	
	}
		
		
	
	@Test	
	public void verifyGetOperation() throws Exception {
		//String uri = "http://localhost:8080/customers";
		
		List<Customer> customers = testRestTemplate.getForObject( "http://localhost:8080/customers" , ArrayList.class);
				  
		assertThat(customers, notNullValue());

				
		
	}
	
	
	
	      
	
	
	
	
	
	
}
