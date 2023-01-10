package com.maplr.mapper;

import org.mapstruct.Mapper;

import com.maplr.dto.ProductDto;
import com.maplr.entity.Product;

/**
 * Mapper produit
 * @author mamad
 *
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {
	/**
	 * Mappe Product vers ProductDto
	 * @param product
	 * @return ProductDto
	 */
	ProductDto toProductDto(Product product);
	
	/**
	 * Mappe ProductDto vers Product
	 * @param productDto
	 * @return Product
	 */
	Product fromProductDto(ProductDto productDto);
}
