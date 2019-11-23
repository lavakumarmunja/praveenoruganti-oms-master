package com.praveen.oms.customer;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.praveen.oms.customer.model.Customer;
import com.praveen.oms.customer.service.CustomerService;

@SpringBootTest
public class CustomerServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;

	@Test
	public void whenFindAll_thenReturnCustomerList() throws Exception {
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

		doReturn(listOfExpectedCustomers).when(customerService).getCustomers();
		// when + then
		this.mockMvc.perform(get("/customerservice/customers")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].firstname", is(custOne.getFirstname())));

	}

}
