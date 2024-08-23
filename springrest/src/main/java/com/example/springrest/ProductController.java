package com.example.springrest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping(value = "/product")
	public Product newProduct(@RequestBody Product newProduct) {
		
		return productService.save(newProduct);
	}

	@GetMapping(value = "/product/{id}")
	public Product getProdID(@PathVariable int id) {
		
		return productService.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
	}

	@PutMapping("/product/{id}")
	Product replaceProduct(@RequestBody Product newProduct, @PathVariable int id) {
		
		return productService.findById(id).map(product -> {
			product.setPname(newProduct.getPname());
			product.setBatchno(newProduct.getBatchno());
			product.setPrice(newProduct.getPrice());
			product.setNumprod(newProduct.getNumprod());
			return productService.save(product);
		}).orElseGet(() -> {
			return productService.save(newProduct);
		});
	}

	@DeleteMapping("/product/{id}")
	void deleteEmployee(@PathVariable int id) {
		
		productService.deleteById(id);
	}
}
