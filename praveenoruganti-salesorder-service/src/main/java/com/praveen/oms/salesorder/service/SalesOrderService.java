package com.praveen.oms.salesorder.service;

import com.praveen.oms.salesorder.model.Order;
import com.praveen.oms.salesorder.request.OrderRequest;


public interface SalesOrderService {
	public Order createOrder(OrderRequest orderRequest);

}
