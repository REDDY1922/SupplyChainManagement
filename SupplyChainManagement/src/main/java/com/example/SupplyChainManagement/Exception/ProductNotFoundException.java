package com.example.SupplyChainManagement.Exception;

public class ProductNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ProductNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
}
