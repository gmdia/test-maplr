package com.maplr.service;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Service
@Api(tags = "Service produit")
public class ProductService {
	private final ProductRepository productRepository;
	private ProductMapper productMapper;

	@Autowired
	public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
		this.productRepository = productRepository;
		this.productMapper = productMapper;
	}

	@ApiOperation(value = "Recupere le catalogue produit")
	public List<CatalogueItemDto> getCatalogue(ProductType type) {
		List<Product> products = type != null ? productRepository.findByType(type) : productRepository.findAll();
		List<ProductDto> productDtos = products.stream().map(productMapper::toProductDto).collect(Collectors.toList());
		return productDtos.stream().map(this::toCatalogueItemDto).collect(Collectors.toList());
	}

	@ApiOperation(value = "Check si le produit exist")
	public boolean productExists(String productId) {
		return productRepository.findAll().stream().anyMatch(product -> product.getId().equals(productId));
	}

	@ApiOperation(value = "Recupere produit par id")
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
