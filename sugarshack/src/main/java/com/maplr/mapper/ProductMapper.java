package com.maplr.mapper;

import org.mapstruct.Mapper;

import com.maplr.dto.ProductDto;
import com.maplr.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	ProductDto toProductDto(Product product);
	Product fromProductDto(ProductDto productDto);
}
