package com.test.maplr.sugarshack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.maplr.dto.CatalogueItemDto;
import com.maplr.dto.ProductDto;
import com.maplr.entity.Product;
import com.maplr.enumeration.ProductType;
import com.maplr.mapper.ProductMapper;
import com.maplr.repository.ProductRepository;
import com.maplr.service.ProductService;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
	@Mock
	private ProductRepository productRepository;

	@Mock
	private ProductMapper productMapper;

	private ProductService productService;

	@BeforeEach
	public void setUp() {
		productService = new ProductService(productRepository, productMapper);
	}

	@Test
	void productExists_shouldReturnTrue_whenProductExists() {
		// Given
		Product product = Product.builder()
				.id("123").name("Produit 01")
				.type(ProductType.AMBER.getLibelle())
				.price(BigDecimal.valueOf(10))
				.build();

		when(productRepository.findAll()).thenReturn(Collections.singletonList(product));

		// When
		boolean result = productService.productExists("123");

		// Then
		assertTrue(result);
	}

	@Test
	void productExists_shouldReturnFalse_whenProductDoesNotExist() {
		// Given
		Product product = Product.builder()
				.id("123")
				.name("Produit 01")
				.type(ProductType.AMBER.getLibelle())
				.price(BigDecimal.valueOf(10))
				.build();

		when(productRepository.findAll()).thenReturn(Collections.singletonList(product));

		// When
		boolean result = productService.productExists("456");

		// Then
		assertFalse(result);
	}

	@Test
	void getByProductId_shouldReturnProductDto_whenProductExists() {
		// Given
		Product product = Product.builder()
				.id("123")
				.name("Produit 01")
				.type(ProductType.AMBER.getLibelle())
				.price(BigDecimal.valueOf(10))
				.build();

		ProductDto productDto = ProductDto.builder()
				.id(product.getId())
				.name(product.getName())
				.type(ProductType.fromLibelle(product.getType()))
				.price(product.getPrice())
				.build();

		when(productRepository.findByProductId("123")).thenReturn(product);
		when(productMapper.toProductDto(product)).thenReturn(productDto);

		// When
		ProductDto result = productService.getByProductId("123");

		// Then
		assertEquals(productDto.getId(), result.getId());
		assertEquals(productDto.getName(), result.getName());
		assertEquals(productDto.getType(), result.getType());
		assertEquals(productDto.getPrice(), result.getPrice());
	}

	@Test
	void getCatalogue_shouldReturnCatalogueItemDtoList_whenTypeIsNull() {
		// Given
		Product product = Product.builder()
				.id("123")
				.name("Produit 01")
				.type(ProductType.AMBER.getLibelle())
				.price(BigDecimal.valueOf(10))
				.build();

		ProductDto productDto = ProductDto.builder()
				.id(product.getId())
				.name(product.getName())
				.type(ProductType.fromLibelle(product.getType()))
				.price(product.getPrice())
				.build();

		when(productRepository.findAll()).thenReturn(Collections.singletonList(product));
		when(productMapper.toProductDto(product)).thenReturn(productDto);

		// When
		List<CatalogueItemDto> result = productService.getCatalogue(null);

		// Then
		assertEquals(1, result.size());
		assertEquals(productDto.getId(), result.get(0).getId());
		assertEquals(productDto.getName(), result.get(0).getName());
		assertEquals(productDto.getType(), result.get(0).getType());
		assertEquals(productDto.getPrice(), result.get(0).getPrice());
	}
	
	@Test
	void getCatalogue_shouldReturnCatalogueItemDtoList_whenTypeIsNotNull() {
		// Given
		Product product = Product.builder()
				.id("123")
				.name("Produit 01")
				.type(ProductType.AMBER.getLibelle())
				.price(BigDecimal.valueOf(10))
				.build();

		ProductDto productDto = ProductDto.builder()
				.id(product.getId())
				.name(product.getName())
				.type(ProductType.fromLibelle(product.getType()))
				.price(product.getPrice())
				.build();

		when(productRepository.findByType(ProductType.AMBER)).thenReturn(Collections.singletonList(product));
		when(productMapper.toProductDto(product)).thenReturn(productDto);

		// When
		List<CatalogueItemDto> result = productService.getCatalogue(ProductType.AMBER);

		// Then
		assertEquals(1, result.size());
		assertEquals(productDto.getId(), result.get(0).getId());
		assertEquals(productDto.getName(), result.get(0).getName());
		assertEquals(productDto.getType(), result.get(0).getType());
		assertEquals(productDto.getPrice(), result.get(0).getPrice());
	}
}
