package com.maplr.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maplr.dto.CatalogueItemDto;
import com.maplr.dto.ProductDto;
import com.maplr.entity.Product;
import com.maplr.enumeration.ProductType;
import com.maplr.mapper.ProductMapper;
import com.maplr.repository.ProductRepository;
import com.maplr.service.ProductService;

import io.swagger.annotations.Api;

@Service
@Api(tags = "Service produit")
public class ProductServiceImpl implements ProductService{
	private final ProductRepository productRepository;
	private ProductMapper productMapper;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
		this.productRepository = productRepository;
		this.productMapper = productMapper;
	}

	@Override
	public List<CatalogueItemDto> getCatalogue(ProductType type) {
		List<Product> products = type != null ? productRepository.findByType(type) : productRepository.findAll();
		List<ProductDto> productDtos = products.stream().map(productMapper::toProductDto).collect(Collectors.toList());
		return productDtos.stream().map(this::toCatalogueItemDto).collect(Collectors.toList());
	}

	@Override
	public boolean productExists(String productId) {
		return productRepository.findAll().stream().anyMatch(product -> product.getId().equals(productId));
	}

	@Override
	public ProductDto getByProductId(String productId) {
		return productMapper.toProductDto(productRepository.findByProductId(productId));
	}

	private CatalogueItemDto toCatalogueItemDto(ProductDto productDto) {
		return CatalogueItemDto.builder()
				.id(productDto.getId())
				.name(productDto.getName())
				.type(productDto.getType())
				.price(productDto.getPrice())
				.build();
	}

}
