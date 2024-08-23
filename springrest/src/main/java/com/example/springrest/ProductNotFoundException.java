package com.example.springrest;

@SuppressWarnings("serial")
public class ProductNotFoundException extends RuntimeException {
	
	ProductNotFoundException(int id) {
		super("Could not find product with id:" + id);
	}

}
