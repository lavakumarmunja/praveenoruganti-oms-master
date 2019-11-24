package com.praveen.oms.customer.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.oms.customer.error.ErrorResponse;
import com.praveen.oms.customer.error.ErrorResponse.ErrorDetails;
import com.praveen.oms.customer.model.Customer;
import com.praveen.oms.customer.request.CustomerRequest;
import com.praveen.oms.customer.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import lombok.extern.slf4j.Slf4j;

@Api(value = "CustomerController", tags = { "Customer Controller" })
@SwaggerDefinition(tags = { @Tag(name = "Customer Controller", description = "Controller for Customer Service") })
@RestController
@Slf4j
@RequestMapping("/customerservice")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	

	@GetMapping("/customers")
	@ApiOperation(value = "Gets all the Customers")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Customer not found"),
			@ApiResponse(code = 200, message = "OK") })
	public ResponseEntity<List<Customer>> getCustomers() {
			return new ResponseEntity<List<Customer>>(customerService.getCustomers(), HttpStatus.OK);
	}

	@PostMapping(value = "/customers", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Creates new customer")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Customer Created Successfully"),
			@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "BAD REQUEST") })
	public ResponseEntity<?> createCustomer(
			@ApiParam("Customer information for a new customer to be created.") @Valid @RequestBody CustomerRequest customerRequest,
			Errors errors) {
		if (errors.hasErrors()) {
			List<ErrorDetails> errorDetails = new ArrayList<>();
			for (FieldError fieldError : errors.getFieldErrors()) {
				ErrorDetails error = new ErrorDetails();
				error.setFieldName(fieldError.getField());
				error.setMessage(fieldError.getDefaultMessage());
				errorDetails.add(error);
			}
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setErrorCode("4000");
			errorResponse.setErrorMessage("BAD REQUEST");
			errorResponse.setTimestamp(new Date());
			errorResponse.setErrors(errorDetails);
			log.info("CustomerController createCustomer() request validation error is "+ errorResponse);
			return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Customer>(customerService.createCustomer(customerRequest), HttpStatus.CREATED);
		}
	}

}
