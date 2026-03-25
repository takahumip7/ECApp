package com.ec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ec.dto.ProductCreateRequest;
import com.ec.dto.ProductResponse;
import com.ec.entity.Product;
import com.ec.mapper.ProductMapper;

@Service
public class ProductService {

	private final ProductMapper productMapper;

	public ProductService(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}
	
	// 商品一覧
	public List<ProductResponse> getProducts() {
		
		List<Product> products = productMapper.findAll();
		
		return products.stream().map(p -> new ProductResponse(
					p.getId(),
					p.getName(),
					p.getDescription(),
					p.getPrice()
				))
				.collect(Collectors.toList());
	}
	
	// 商品登録
	public Long createProduct(ProductCreateRequest dto) {
		
		Product product = new Product();
		
		product.setName(dto.getName());
		product.setDescription(dto.getDescription());
		product.setPrice(dto.getPrice());
		product.setStock(dto.getStock());
		
		productMapper.insert(product);
		
		return product.getId();
	}
	
	// 商品詳細
	public ProductResponse getProduct(Long id) {
		
		Product product = productMapper.findById(id);
		
		if (product == null) {
			throw new RuntimeException("商品が存在しません。");
		}
		
		return new ProductResponse(
			product.getId(),
			product.getName(),
			product.getDescription(),
			product.getPrice()
			);
	}
	
	public void updateProduct(Long id, ProductCreateRequest dto) {
		Product product = new Product();
		product.setId(id);
		product.setName(dto.getName());
		product.setDescription(dto.getDescription());
		product.setPrice(dto.getPrice());
		product.setStock(dto.getStock());
		
		productMapper.update(product);
	}
	
	public void deleteProduct(Long id) {
		productMapper.delete(id);
	}
}
