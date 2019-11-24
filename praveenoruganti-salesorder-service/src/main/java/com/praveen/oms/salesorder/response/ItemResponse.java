package com.praveen.oms.salesorder.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class ItemResponse {
	private Long id;
	private String itemname;
	private String description;
	private Double price;
	private String creationdate;
}
