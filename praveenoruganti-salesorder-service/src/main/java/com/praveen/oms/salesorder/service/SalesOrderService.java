package com.praveen.oms.salesorder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.praveen.oms.salesorder.exception.CustomerNotFoundException;
import com.praveen.oms.salesorder.exception.ItemNotFoundException;
import com.praveen.oms.salesorder.model.Customer;
import com.praveen.oms.salesorder.model.Order;
import com.praveen.oms.salesorder.model.OrderLineItem;
import com.praveen.oms.salesorder.repository.CustomerRepository;
import com.praveen.oms.salesorder.repository.OrderLineItemRepository;
import com.praveen.oms.salesorder.repository.OrderRepository;
import com.praveen.oms.salesorder.request.OrderRequest;
import com.praveen.oms.salesorder.response.ItemResponse;

@Service
public class SalesOrderService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderLineItemRepository orderLineItemRepository;

	@Autowired
	CustomerRepository customerRepository;

	public Customer createOrder(OrderRequest orderRequest) {
		if (customerRepository.findById(orderRequest.getCustid()).isPresent()) { // validate customer id
			List<String> availableItems = new ArrayList<>();
			// validate the placed order Items by calling the Itemservice
			orderRequest.getItemNames().forEach(
				item -> {
					ItemResponse itemResponse = restTemplate
							.getForObject("http://localhost:6072/itemservice/item/" + item, ItemResponse.class);
					System.out.println("itemResponse"+ itemResponse);					
					if (itemResponse != null && itemResponse.getItemname() !=null) {
						availableItems.add(itemResponse.getItemname());
					}
				}
			);
			if (availableItems.size() > 0) {
				Order order = orderRepository.saveAndFlush(Order.builder().custId(orderRequest.getCustid())
						.orderDate(orderRequest.getOrderdate()).orderDesc(orderRequest.getOrderdesc())
						.totalPrice(orderRequest.getTotalprice()).build());
				availableItems.forEach(itemName -> orderLineItemRepository
						.saveAndFlush(OrderLineItem.builder().itemName(itemName).orderId(order.getId()).build()));

			} else {
				throw new ItemNotFoundException("Item not found");
			}

		} else {
			throw new CustomerNotFoundException("Customer not found");
		}

		return null;
	}

}