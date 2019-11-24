package com.praveen.oms.salesorder.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.praveen.oms.salesorder.erros.ErrorResponse;
import com.praveen.oms.salesorder.exception.CustomerNotFoundException;
import com.praveen.oms.salesorder.exception.ItemNotFoundException;

@RestControllerAdvice
public class OrderControllerAdvice {
	
	 @ExceptionHandler(CustomerNotFoundException.class)
	  public  ResponseEntity<ErrorResponse> handleNotFoundException(CustomerNotFoundException ex) {
		    ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setErrorCode("4001");
			errorResponse.setErrorMessage(ex.getMessage());
	    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	  }
	 
	 @ExceptionHandler(ItemNotFoundException.class)
	  public  ResponseEntity<ErrorResponse> handleNotFoundException(ItemNotFoundException ex) {
		    ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setErrorCode("4001");
			errorResponse.setErrorMessage(ex.getMessage());
	    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	  }

}
