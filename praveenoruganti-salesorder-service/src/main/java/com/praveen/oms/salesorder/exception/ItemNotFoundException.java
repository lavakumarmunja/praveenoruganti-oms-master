package com.praveen.oms.salesorder.exception;

public class ItemNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 3336413703867552364L;

	public ItemNotFoundException(String message) {
		super(message);
	}

}
