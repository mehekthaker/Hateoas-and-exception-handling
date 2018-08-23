package com.cg.customers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.customers.controller.CustomerController;
import com.cg.customers.service.ServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
//@WebMvcTest(value=CustomerController.class, secure=false)
public class JunitTestCases {

//	@Autowired
	private MockMvc mockMvc;
	
	@Mock 
	private ServiceImpl service;
	
	@InjectMocks
	private CustomerController customerController;
	
	//Customer mockCustomer = new Customer();
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(customerController)
				.build();
//		System.out.println(mockMvc);
//		System.out.println(service);
//		System.out.println(customerController);
	}
	
	@Test
	
	public void verifyGetOperation() throws Exception {
		//String json = "{\"customerId\":\"122\",\"customerName\":\"Nyaah\",\"contactNumber\":\"986755\",\"emailId\":\"nyaah@gmail.com\",\"dateOfBirth\":\"22/4/1993\"}";
		
		mockMvc.perform(get("/customers")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.*", Matchers.hasSize(5))).andDo(print());
				/*.andExpect(jsonPath("$.customerName", Matchers.is("Nyaah")))
				.andExpect(jsonPath("$.contactNumber", Matchers.is(986755)))
				.andExpect(jsonPath("$.emailId", Matchers.is("nyaah@gmail.com")))
				.andExpect(jsonPath("$.dateOfBirth", Matchers.is("22/4/1993")))
				.andExpect(jsonPath("$.*", Matchers.hasSize(5)));
*/		
	}
	
	
	
	@Test
	public void testPost() throws Exception {
		String json = "{\"customerId\":\"122\",\"customerName\":\"Nyaah\",\"contactNumber\":\"986755\",\"emailId\":\"nyaah@gmail.com\",\"dateOfBirth\":\"22/4/1993\"}";
		
		mockMvc.perform(post("/customer/add")
				.contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk());
				/*.andExpect(jsonPath("$.customerId", Matchers.is(122)))
				.andExpect(jsonPath("$.customerName", Matchers.is("Nyaah")))
				.andExpect(jsonPath("$.contactNumber", Matchers.is(986755)))
				.andExpect(jsonPath("$.emailId", Matchers.is("nyaah@gmail.com")))
				.andExpect(jsonPath("$.dateOfBirth", Matchers.is("22/4/1993")))
				.andExpect(jsonPath("$.*", Matchers.hasSize(5)));*/
		
	}
	
	
	@Test
	public void testDelete() throws Exception {
		mockMvc.perform(delete("/customer/delete/112").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.status").value(200))
		.andExpect(jsonPath("$.message").value("Record deleted successfully"));
	}
}
