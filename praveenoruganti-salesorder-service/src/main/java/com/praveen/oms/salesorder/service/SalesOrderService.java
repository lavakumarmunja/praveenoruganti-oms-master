package com.praveen.oms.salesorder.service;

import com.praveen.oms.salesorder.model.Customer;
import com.praveen.oms.salesorder.request.OrderRequest;


public interface SalesOrderService {
	public Customer createOrder(OrderRequest orderRequest);

}
