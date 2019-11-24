package com.praveen.oms.customer.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.praveen.oms.customer.error.ErrorResponse;
import com.praveen.oms.customer.exception.CustomerNotFoundException;

@RestControllerAdvice
public class CustomerControllerAdvice {
	
	 @ExceptionHandler(CustomerNotFoundException.class)
	  public  ResponseEntity<ErrorResponse> handleNotFoundException(CustomerNotFoundException ex) {
		    ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setErrorCode("4001");
			errorResponse.setErrorMessage(ex.getMessage());
	    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	  }

}
