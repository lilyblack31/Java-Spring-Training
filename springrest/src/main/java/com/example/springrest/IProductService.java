package com.example.springrest;

import java.util.List;
import java.util.Optional;

public interface IProductService {

	List<Product> findAll();

	Product save(Product newProduct);

	Optional<Product> findById(int id);

	void deleteById(int id);
}
