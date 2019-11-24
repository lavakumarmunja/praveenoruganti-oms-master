package com.praveen.oms.salesorder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="SALES_ORDER")
@SuperBuilder
@Data
@NoArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="ORDER_DATE",length = 20, nullable = false)
	private String orderDate;
	
	@Column(name="CUST_ID")
	private Long custId;
	
	@Column(name="ORDER_DESC",length = 100, nullable = false)
	private String orderDesc;
	
	@Column(name="TOTAL_PRICE")
	private Double totalPrice;
}
