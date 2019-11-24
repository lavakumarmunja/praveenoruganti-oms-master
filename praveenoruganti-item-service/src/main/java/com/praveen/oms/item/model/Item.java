package com.praveen.oms.item.model;

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
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private Long id;	
	@Column(name="ITEM_NAME",length = 50, nullable = false)
	private String itemname;
	@Column(name="DESCRIPTION",length = 100, nullable = false)
	private String description;		
	@Column(name="PRICE")
	private Double price;
	@Column(name="CREATION_DATE",length = 20, nullable = false)
	private String creationdate;

}
