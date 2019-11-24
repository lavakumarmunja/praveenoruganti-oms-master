package com.praveen.oms.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@ToString
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private Long id;	
	@Column(name="FIRST_NAME",length = 50, nullable = false)
	private String firstname;	
	@Column(name="LAST_NAME",length = 50, nullable = false)
	private String lastname;	
	@Column(length = 50, nullable = false)
	private String email;	
	@Column(name="CREATION_DATE",length = 20, nullable = false)
	private String creationdate;

}
