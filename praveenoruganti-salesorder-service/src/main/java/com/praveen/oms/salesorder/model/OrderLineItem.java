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
@Table(name="ORDER_LINE_ITEM")
@SuperBuilder
@Data
@NoArgsConstructor
public class OrderLineItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private Long id;	

	@Column(name="ITEM_NAME",length = 50, nullable = false)
	private String itemName;
	
	@Column(name="ITEM_QUANTITY")
	private Double itemQty;
	
	@Column(name="ORDER_ID")
	private Long orderId;
	
}
