package com.praveen.oms.salesorder.exception;

public class CustomerNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 3336413703867552364L;

	public CustomerNotFoundException(String message) {
		super(message);
	}

}
