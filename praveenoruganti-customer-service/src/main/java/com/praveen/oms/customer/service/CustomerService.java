package com.praveen.oms.customer.service;

import java.util.List;

import com.praveen.oms.customer.model.Customer;
import com.praveen.oms.customer.request.CustomerRequest;

public interface CustomerService {
	List<Customer> getCustomers();
	Customer createCustomer(CustomerRequest customerRequest);
}
