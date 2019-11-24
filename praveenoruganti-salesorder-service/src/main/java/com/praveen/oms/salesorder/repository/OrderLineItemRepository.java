package com.praveen.oms.salesorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praveen.oms.salesorder.model.OrderLineItem;

public interface OrderLineItemRepository extends JpaRepository<OrderLineItem, Long> {

}
