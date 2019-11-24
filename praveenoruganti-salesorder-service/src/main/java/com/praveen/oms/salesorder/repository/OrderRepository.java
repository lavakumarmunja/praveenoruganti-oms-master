package com.praveen.oms.salesorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.praveen.oms.salesorder.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
