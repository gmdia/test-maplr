package com.maplr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maplr.entity.Product;
import com.maplr.enumeration.ProductType;

/**
 * Repository produit
 * @author mamad
 *
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
	/**
	 * Renvoie la liste produit par type de produit
	 * @param type : type de produit
	 * @return List<Product> 
	 */
	List<Product> findByType(ProductType type);

	/**
	 * Renvoie un produit par id produit
	 * @param productId : id produit
	 * @return Product
	 */
	Product findByProductId(String productId);
}
