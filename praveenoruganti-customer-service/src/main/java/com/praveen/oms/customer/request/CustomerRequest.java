package com.praveen.oms.customer.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "This request is to create a customer")
@Data
@NoArgsConstructor
public class CustomerRequest{

	@ApiModelProperty(notes = "firstname should have atleast 2 characters", name="firstname",value = "Praveen", required = true)
	@NotBlank(message="firstname should have atleast 2 characters")
	private String firstname;
	@ApiModelProperty(notes = "lastname should have atleast 2 characters", name="lastname",value = "O", required = true)
	@NotBlank(message="lastname should have atleast 1 character")
	private String lastname;
	@ApiModelProperty(name="email",notes = "email must include @ and proper domain",value = "op@gmail.com", required = true)
	@Pattern(regexp="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$",message="Email address must include @ and proper domain")  
	private String email;
	@ApiModelProperty(name="creationdate",notes = "creationdate must be in DD/MM/YYYY", value = "14/09/1985", required = true)
	@Pattern(regexp="(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)",message="creationdate must be in DD/MM/YYYY format")
	private String creationdate;

	
}
