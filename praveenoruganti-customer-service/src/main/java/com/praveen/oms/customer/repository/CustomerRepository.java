package com.praveen.oms.customer.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praveen.oms.customer.model.Customer;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
