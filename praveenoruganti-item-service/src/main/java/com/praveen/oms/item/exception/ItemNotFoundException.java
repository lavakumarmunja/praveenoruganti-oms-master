package com.praveen.oms.item.exception;

public class ItemNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -8262058840312526990L;
	
	public ItemNotFoundException(String message){
		super(message);
	}

}
