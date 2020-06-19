package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.Product;
import com.demo.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@PostMapping("/product")
	public Product addProduct(Product product) {

		System.out.println("product:" + product);

		productRepository.save(product);

		return product;
	}

	@PutMapping("/product")
	public Product updateProduct(Product product) {

		System.out.println("product:" + product);

		productRepository.save(product);

		return product;

	}

	@GetMapping("/products")
	public List<Product> getAllProducts() {

		List<Product> allProductsList = productRepository.findAll();

		return allProductsList;
	}

	@GetMapping("/product/{productId}")
	public Product getProduct(@PathVariable("productId") int productId) {

		Product product = productRepository.findById(productId).orElse(null);

		return product;
	}

	@DeleteMapping("/product/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId) {

		productRepository.deleteById(productId);

		System.out.println("Product deleted = " + productId);

		return "Product deleted = " + productId;
	}

}
