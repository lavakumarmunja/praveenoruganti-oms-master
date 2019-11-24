package com.praveen.oms.salesorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.praveen.oms.salesorder.erros.MyErrorHandler;
import com.praveen.oms.salesorder.model.Customer;
import com.praveen.oms.salesorder.repository.CustomerRepository;
import com.praveen.oms.salesorder.subscribe.CustomerCreatedSource;

@SpringBootApplication
@EnableBinding(CustomerCreatedSource.class)
public class SalesorderServiceApplication {

	@Autowired
	CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(SalesorderServiceApplication.class, args);
	}

	@StreamListener(target = CustomerCreatedSource.INPUT)
	public void processCustomerCreated(Customer customer) {
		System.out.println("Customer Created " + customer.getId());
		customerRepository.saveAndFlush(customer);
	}

	@Bean
	public RestTemplate getRestTemplate() {		
		RestTemplate restTemplate =new RestTemplate();
		restTemplate.setErrorHandler(new MyErrorHandler());
		return restTemplate;
	}

}
