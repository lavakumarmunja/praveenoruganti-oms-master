package com.praveen.oms.customer.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.praveen.oms.customer.controller.CustomerController;
import com.praveen.oms.customer.model.Customer;
import com.praveen.oms.customer.service.CustomerServiceImpl;

@SpringBootTest
public class CustomerControllerTests {
	@Autowired
	private MockMvc mockMvc;

	@Mock
	private CustomerServiceImpl customerService;

	@InjectMocks
	private CustomerController customerController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	@Test
	public void test_GetCustomers() throws Exception {
		List<Customer> listOfExpectedCustomers = new ArrayList<Customer>();
		Customer custOne = Customer.builder().firstname("Praveen").lastname("Oruganti")
				.email("praveenoruganti@gmail.com").creationdate("20/11/2019").build();
		Customer custTwo = Customer.builder().firstname("Kiran").lastname("Oruganti").email("kiranbadugu@yahoo.com")
				.creationdate("21/11/2019").build();
		Customer custThree = Customer.builder().firstname("Praneeth").lastname("Vishnubhotla")
				.email("praneethv@gmail.com").creationdate("22/11/2019").build();
		listOfExpectedCustomers.add(custOne);
		listOfExpectedCustomers.add(custTwo);
		listOfExpectedCustomers.add(custThree);

		when(customerService.getCustomers()).thenReturn(listOfExpectedCustomers);
		this.mockMvc.perform(get("/customerservice/customers")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].firstname", is(custOne.getFirstname())));

	}

}
