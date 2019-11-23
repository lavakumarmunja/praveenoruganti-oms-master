package com.praveen.oms.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.oms.customer.model.Customer;
import com.praveen.oms.customer.repository.CustomerRepository;
import com.praveen.oms.customer.request.CustomerRequest;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer createCustomer(CustomerRequest customerRequest) {
		return customerRepository.saveAndFlush(Customer.builder().email(customerRequest.getEmail())
				.firstname(customerRequest.getFirstname()).lastname(customerRequest.getLastname())
				.creationdate(customerRequest.getCreationdate()).build());
	}
	

}
