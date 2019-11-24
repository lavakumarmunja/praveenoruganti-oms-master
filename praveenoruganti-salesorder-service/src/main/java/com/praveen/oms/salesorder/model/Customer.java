package com.praveen.oms.salesorder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@ToString
@Table(name="Customer_SOS")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="CUST_ID")
	private Long id;	
	@Column(name="CUST_FIRST_NAME",length = 50, nullable = false)
	private String firstname;	
	@Column(name="CUST_LAST_NAME",length = 50, nullable = false)
	private String lastname;	
	@Column(length = 50, nullable = false)
	private String email;	
	@Column(name="CUST_CREATION_DATE",length = 20, nullable = false)
	private String creationdate;

}
