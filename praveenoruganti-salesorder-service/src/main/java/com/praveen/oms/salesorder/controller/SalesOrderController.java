package com.praveen.oms.salesorder.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.oms.salesorder.erros.ErrorResponse;
import com.praveen.oms.salesorder.erros.ErrorResponse.ErrorDetails;
import com.praveen.oms.salesorder.model.Order;
import com.praveen.oms.salesorder.request.OrderRequest;
import com.praveen.oms.salesorder.service.SalesOrderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/salesorderservice")
public class SalesOrderController {

	@Autowired
	SalesOrderService salesOrderService;

	@PostMapping(value = "/orders", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Creates new order")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Order Created Successfully"),
			@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "BAD REQUEST") })
	public ResponseEntity<?> createOrder(
			@ApiParam("Order information for a new order to be created.") @Valid @RequestBody OrderRequest orderRequest,
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
			log.info("SalesOrderController createOrder() request validation error is "+ errorResponse);
			return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		} else {
			Order order = salesOrderService.createOrder(orderRequest);
			return new ResponseEntity<Order>(order, HttpStatus.CREATED);
		}

	}

}
