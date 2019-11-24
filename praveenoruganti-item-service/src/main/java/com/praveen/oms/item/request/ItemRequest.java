package com.praveen.oms.item.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ApiModel(description = "This request is to create an item")
@Data
@NoArgsConstructor
@ToString
public class ItemRequest {
	@ApiModelProperty(notes = "itemname should have atleast 1 character", name="itemname",value = "Redmi Note 8 Pro", required = true)
	@NotBlank(message="itemname should have atleast 1 character")
	private String itemname;
	@ApiModelProperty(notes = "description should not be empty", name="description",value = "Redmi Note 8 Pro has a 68 MP camera", required = true)
	@NotBlank(message="description should have atleast 1 character")
	private String description;	
	@ApiModelProperty(notes = "Price should be a numeric and positive value", name="price",value = "15999.85", required = true)
	@Positive(message="Price should be positive value")
	@NotNull(message=" price should not be empty" )
	private Double price;
	@ApiModelProperty(name="creationdate",notes = "creationdate must be in DD/MM/YYYY", value = "17/11/2019", required = true)
	@Pattern(regexp="(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)",message="creationdate must be in DD/MM/YYYY format")
	private String creationdate;
	
}
