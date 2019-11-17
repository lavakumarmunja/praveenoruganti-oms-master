package com.praveen.oms.item.controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.oms.item.error.ErrorResponse;
import com.praveen.oms.item.error.ErrorResponse.ErrorDetails;
import com.praveen.oms.item.exception.ItemNotFoundException;
import com.praveen.oms.item.model.Item;
import com.praveen.oms.item.request.ItemRequest;
import com.praveen.oms.item.service.ItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@Api(value = "ItemController", tags = { "Item Controller" })
@SwaggerDefinition(tags = { @Tag(name = "Item Controller", description = "Controller for Item Service") })
@RestController
@RequestMapping("/itemservice")
public class ItemController {
	@Autowired
	ItemService itemService;
	
	@GetMapping("/item")
	@ApiOperation(value = "Gets all the Items")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Item not found"),
			@ApiResponse(code = 200, message = "OK") })
	public ResponseEntity<List<Item>> getItems() {
		if (itemService.getItems().size() > 0) {
			return new ResponseEntity<List<Item>>(itemService.getItems(), HttpStatus.OK);
		} else {
			throw new ItemNotFoundException("Item not found");
		}

	}
	
	@GetMapping("/item/{itemname}")
	@ApiOperation(value = "Get Item by Item Name")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Item not found"),
			@ApiResponse(code = 200, message = "OK") })
	public ResponseEntity<Item> getCustomers(@PathVariable String itemname) {
		if (itemService.getByItemname(itemname)!=null) {
			return new ResponseEntity<Item>(itemService.getByItemname(itemname), HttpStatus.OK);
		} else {
			throw new ItemNotFoundException("Item not found");
		}

	}

	@PostMapping(value = "/customer", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Creates new Item")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Item Created Successfully"),
			@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "BAD REQUEST") })
	public ResponseEntity<?> createCustomer(
			@ApiParam("Item information for a new item to be created.") @Valid @RequestBody ItemRequest itemRequest,
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
			return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Item>(itemService.createItem(itemRequest), HttpStatus.CREATED);
		}
	}

}
