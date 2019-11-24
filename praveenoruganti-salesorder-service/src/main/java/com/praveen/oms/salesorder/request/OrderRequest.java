package com.praveen.oms.salesorder.request;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@ApiModel(description = "This request is to create an Order")
@Data
@NoArgsConstructor
@SuperBuilder
public class OrderRequest {

	@ApiModelProperty(name = "orderdate", notes = "orderDate must be in DD/MM/YYYY", value = "24/11/2019", required = true)
	@Pattern(regexp = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)", message = "orderdate must be in DD/MM/YYYY format")
	private String orderdate;

	@Positive(message = "custid should be a positive value")
	@NotNull(message = "custid should have atleast 1 digit")
	@ApiModelProperty(notes = "customer id should have positive value", name = "custid", value = "1L", required = true)
	private Long custid;

	@ApiModelProperty(notes = "orderdesc should have atleast few words", name = "orderdesc", value = "Redmi note8 pro has 64 MP camera", required = true)
	@NotBlank(message = "orderdesc should have atleast few words")
	private String orderdesc;

	@Positive(message = "totalprice should be a positive value")
	@NotNull(message = "totalprice should have atleast 1 digit")
	@ApiModelProperty(notes = "totalprice should have positive value", name = "totalprice", value = "15999.98", required = true)
	private Double totalprice;	
	
	@ApiModelProperty(notes = "item names must not be empty", name = "orderdesc", value = "{Redmi note8 pro, Iphone}", required = true)
	@NotNull(message = "item names must not be empty")
	private List<String> itemNames;
}
