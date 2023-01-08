package com.maplr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maplr.entity.Product;
import com.maplr.enumeration.ProductType;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByType(ProductType type);

	Optional<Product> findById(Long id);

	List<Product> findAll();
	
	Product findByProductId(String productId);
}
