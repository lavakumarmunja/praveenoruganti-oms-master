package com.praveen.oms.customer.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.praveen.oms.customer.model.Customer;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
public class CustomerRepositoryTests {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	public void testCreateCustomer() {
		Customer customer = Customer.builder().firstname("Praveen").lastname("Oruganti")
				.email("praveenoruganti@gmail.com").creationdate("20/11/2019").build();
		Customer custome2 =customerRepository.saveAndFlush(customer);			
		assertNotNull(customer);
		assertEquals(custome2.getFirstname(), customer.getFirstname());
		assertEquals(custome2.getLastname(), customer.getLastname());
	}
	
	
	@Test
	public void testGetCustomer() {
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
		
		customerRepository.saveAll(listOfExpectedCustomers);
		
		List<Customer> listOfActualCustomers = customerRepository.findAll();
				
		assertNotNull(listOfActualCustomers);
		
		assertEquals(listOfExpectedCustomers.size(), listOfActualCustomers.size());
	
	}

}
