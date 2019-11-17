package com.praveen.oms.salesorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.praveen.oms.salesorder.subscribe.CustomerCreatedSource;

@SpringBootApplication
@EnableBinding(CustomerCreatedSource.class)
public class SalesorderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesorderServiceApplication.class, args);
	}
	
	@StreamListener(target = CustomerCreatedSource.INPUT)
	public void processCustomerCreated(String customer) {
		System.out.println("Customer Created " + customer);
	}

}
