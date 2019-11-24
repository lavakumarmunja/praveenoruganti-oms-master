package com.praveen.oms.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.praveen.oms.customer.exception.CustomerNotFoundException;
import com.praveen.oms.customer.model.Customer;
import com.praveen.oms.customer.publish.CustomerCreatedSource;
import com.praveen.oms.customer.repository.CustomerRepository;
import com.praveen.oms.customer.request.CustomerRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@EnableBinding(CustomerCreatedSource.class)
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerCreatedSource customerCreatedSource;

	@Override
	public List<Customer> getCustomers() {
		log.info("CustomerServiceImpl getCustomers() Starts");
		List<Customer> customerList = customerRepository.findAll();
		if(customerList.size()==0) {
			throw new CustomerNotFoundException("Customer not found");
		}
		log.info("Customer List size is "+ customerList.size());
		log.info("CustomerServiceImpl getCustomers() Ends");
		return customerList;
	}

	@Override
	public Customer createCustomer(CustomerRequest customerRequest) {
		log.info("CustomerServiceImpl createCustomer() Starts");
		log.info("Customer Request in createCustomer()  is "+customerRequest);
		Customer customer = customerRepository.saveAndFlush(Customer.builder().email(customerRequest.getEmail())
				.firstname(customerRequest.getFirstname()).lastname(customerRequest.getLastname())
				.creationdate(customerRequest.getCreationdate()).build());
		log.info("Customer Response in createCustomer()  is "+customer);
		if(null!=customerCreatedSource) {
		  customerCreatedSource.customerCreated().send(MessageBuilder.withPayload(customer).build());
		  log.info("CustomerServiceImpl createCustomer() customer message published to queue and it is ready for listening");
		}
		log.info("CustomerServiceImpl createCustomer() Ends");
		return customer;
	}

}
