package com.cg.customerproject.junittest;

import static org.assertj.core.api.Assertions.assertThat;
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
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cg.customerproject.App;
import com.cg.customerproject.controller.CustomerController;
import com.cg.customerproject.service.ServiceImpl;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
//@WebMvcTest(value=CustomerController.class, secure=false)
public class JunitTestCases {

//	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;
	
	@Mock 
	private ServiceImpl service;
	
	@InjectMocks
	private CustomerController customerController;
	
	//Customer mockCustomer = new Customer();
	
	@Before
	public void setUp() {
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		/*mockMvc = MockMvcBuilders.standaloneSetup(customerController)
				.build();*/
//		System.out.println(mockMvc);
//		System.out.println(service);
//		System.out.println(customerController);
	}
	
	@Test
	public void testControllerInitialized() {
		assertThat(customerController).isNotNull();
	}
	
	
	@Test
	public void testMockCreation() {
		assertThat(service).isNotNull();
	}
	
	
	
	@Test
	public void verifyGetOperationById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/customer/119").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.customerId").exists())
		.andExpect(jsonPath("$.customerName").exists())
		.andExpect(jsonPath("$.contactNumber").exists())
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		.andExpect(jsonPath("$.id").value(3))
		.andExpect(jsonPath("$.text").value("Build the artifacts"))
		.andExpect(jsonPath("$.completed").value(false))
		.andDo(print());
	}
	
	
	
	@Test	
	public void verifyGetOperation() throws Exception {
		//String json = "{\"customerId\":\"122\",\"customerName\":\"Nyaah\",\"contactNumber\":\"986755\",\"emailId\":\"nyaah@gmail.com\",\"dateOfBirth\":\"22/4/1993\"}";
		
		mockMvc.perform(get("/customers")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andDo(print())
				.andExpect(jsonPath("$", Matchers.hasSize(9))).andDo(print());
				/*.andExpect(jsonPath("$.customerName", Matchers.is("Nyaah")))
				.andExpect(jsonPath("$.contactNumber", Matchers.is(986755)))
				.andExpect(jsonPath("$.emailId", Matchers.is("nyaah@gmail.com")))
				.andExpect(jsonPath("$.dateOfBirth", Matchers.is("22/4/1993")))
				.andExpect(jsonPath("$.*", Matchers.hasSize(5)));
*/		
	}
	
	
	
	@Test
	//@Ignore
	public void testPost() throws Exception {
		//String json = "{\"customerId\":\"122\",\"customerName\":\"Nyaah\",\"contactNumber\":\"986755\",\"emailId\":\"nyaah@gmail.com\",\"dateOfBirth\":\"22/4/1993\"}";
		
		/*((MockHttpServletRequestBuilder) mockMvc.perform(post("/customer/add")
				.contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk()).andDo(print()))*/
				mockMvc.perform(MockMvcRequestBuilders.post("/customer/add")
		        .contentType(MediaType.APPLICATION_JSON).content("{\"customerName\":\"Amaya\",\"contactNumber\":\"9844900\",\"emailId\":\"amaya@gmail.com\",\"dateOfBirth\":\"2/5/1990\"}")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.customerId").exists())
				.andExpect(jsonPath("$.customerName").exists())
				.andExpect(jsonPath("$.contactNumber").exists())
				.andExpect(jsonPath("$.emailId").exists())
				.andExpect(jsonPath("$.dateOfBirth").exists())
				/*.andExpect(jsonPath("$.customerId").value("123"))*/
				.andExpect(jsonPath("$.customerName").value("Amaya"))
				.andExpect(jsonPath("$.contactNumber").value(9844900))
				.andExpect(jsonPath("$.emailId").value("amaya@gmail.com"))
				.andExpect(jsonPath("$.dateOfBirth").value("2/5/1990"))
				.andDo(print());
				/*.andExpect(jsonPath("$.customerId", Matchers.is(122)))
				.andExpect(jsonPath("$.customerName", Matchers.is("Nyaah")))
				.andExpect(jsonPath("$.contactNumber", Matchers.is(986755)))
				.andExpect(jsonPath("$.emailId", Matchers.is("nyaah@gmail.com")))
				.andExpect(jsonPath("$.dateOfBirth", Matchers.is("22/4/1993")))
				.andExpect(jsonPath("$.*", Matchers.hasSize(5)));*/
		
	}
	
	
	@Test
	@Ignore
	public void testDelete() throws Exception {
		mockMvc.perform(delete("/customer/delete/112").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.status").value(200))
		.andExpect(jsonPath("$.message").value("Record deleted successfully"));
	}
	
	
	
	@Test
	@Ignore
	public void testUpdate() throws Exception {
		mockMvc.perform(post("/customer/update")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"customerId\":\"114\",\"customerName\":\"Rihana\",\"contactNumber\":\"9866445\",\"emailId\":\"rihana@gmail.com\",\"dateOfBirth\":\"2/8/1997\"}")
		.accept(MediaType.APPLICATION_JSON)).andDo(print())
		.andExpect(jsonPath("$.customerId").exists())
		.andExpect(jsonPath("$.customerName").exists())
		.andExpect(jsonPath("$.contactNumber").exists())
		.andExpect(jsonPath("$.emailId").exists())
		.andExpect(jsonPath("$.dateOfBirth").exists())
		.andExpect(jsonPath("$.customerName").value("Rihana"))
		.andExpect(jsonPath("$.contactNumber").value(9866445))
		.andExpect(jsonPath("$.emailId").value("rihana@gmail.com"))
		.andExpect(jsonPath("$.dateOfBirth").value("2/8/1997"))
		.andDo(print());
	}
}
