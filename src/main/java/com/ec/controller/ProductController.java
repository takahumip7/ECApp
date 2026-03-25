package com.ec.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.dto.ProductCreateRequest;
import com.ec.dto.ProductResponse;
import com.ec.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public List<ProductResponse> getProducts() {
		return productService.getProducts();
	}
	
	@GetMapping("/{id}")
	public ProductResponse getProduct(@PathVariable Long id) {
		return productService.getProduct(id);
	}
	
	@PostMapping
	public Long createProduct(@RequestBody ProductCreateRequest dto) {
		return productService.createProduct(dto);
	}
	
	@PutMapping("/{id}")
	public void updateProduct(@PathVariable Long id, @RequestBody ProductCreateRequest dto) {
		productService.updateProduct(id, dto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
}
