package com.praveen.oms.customer.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
		customerRepository.saveAndFlush(customer);
		Customer custome2 = customerRepository.findAll().get(0);
		assertNotNull(customer);
		assertEquals(custome2.getFirstname(), customer.getFirstname());
		assertEquals(custome2.getLastname(), customer.getLastname());
	}

}
