package com.webservices.restservice.Hello;

public class HelloBean {
	
	private String message;

	public HelloBean(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "HelloBean [message=" + message + "]";
	}
	
	
	
	

}
