package com.praveen.oms.customer.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.praveen.oms.customer.model.Customer;
import com.praveen.oms.customer.repository.CustomerRepository;
import com.praveen.oms.customer.service.CustomerServiceImpl;

@SpringBootTest
public class CustomerServiceTests {

	@InjectMocks
	CustomerServiceImpl customerService; // the service you want to test

	@Mock
	CustomerRepository customerRepository; // the service dependencies

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getCustomersTest() {
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

		doReturn(listOfExpectedCustomers).when(customerRepository).findAll();

		// when
		List<Customer> listOfActualCustomers = customerService.getCustomers();

		// then
		assertThat(listOfActualCustomers).isEqualTo(listOfExpectedCustomers);

	}
}
