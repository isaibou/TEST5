package com.example.demo.exception;

public class OrderDate extends RuntimeException {

		public OrderDate(String message) {

			super(message);
		}	
	public OrderDate(String message, Throwable cause) {
		
		super(message, cause);
		}


}
