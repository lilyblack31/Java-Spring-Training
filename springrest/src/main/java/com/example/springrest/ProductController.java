package com.example.springrest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	private IProductService productService; 
	
	@GetMapping(value = "/product")
	public List<Product> getProduct() {
		
		List<Product> products = productService.findAll();
		return products;
	}
	
}
