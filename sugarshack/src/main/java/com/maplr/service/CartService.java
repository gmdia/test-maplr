package com.maplr.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maplr.dto.CartLineDto;
import com.maplr.dto.ProductDto;
import com.maplr.entity.CartLine;
import com.maplr.exception.ProductNotFoundException;
import com.maplr.mapper.CartLineMapper;
import com.maplr.repository.CartRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Service
@Api(tags = "Service panier")
public class CartService {
	private final ProductService productService;
	private final CartRepository cartRepository;
	private CartLineMapper cartLineMapper;

	@Autowired
	public CartService(CartRepository cartRepository, ProductService productService, CartLineMapper cartLineMapper) {
		this.cartRepository = cartRepository;
		this.productService = productService;
		this.cartLineMapper = cartLineMapper;
	}

	@ApiOperation(value = "Ajoute un produit")
	public void addToCart(String productId, int qty) {
		if (!productService.productExists(productId)) {
			throw new ProductNotFoundException();
		}
		
		CartLine cartLine = cartRepository.findByProductId(productId);
		if (cartLine != null) {
			ProductDto productDto = productService.getByProductId(productId);
			cartLine = CartLine.builder()
					.productId(productId)
					.qty(qty)
					.name(productDto.getName())
					.price(productDto.getPrice())
					.build();
			
			cartRepository.save(cartLine);
		} else {
			throw new ProductNotFoundException();
		}
	}

	@ApiOperation(value = "Modifie la quantite d'un produit")
	public CartLineDto changeQty(String productId, int qty) {
		if (qty <= 0) {
			throw new IllegalArgumentException("La quantite ne peut etre en dessous de 0");
		}
		
		if (!productService.productExists(productId)) {
			throw new ProductNotFoundException();
		}
		
		CartLine cartLine = cartRepository.findByProductId(productId);
		if (cartLine != null) {
			ProductDto productDto = productService.getByProductId(productId);
			cartLine = CartLine.builder()
					.productId(productId)
					.name(productDto.getName())
					.price(productDto.getPrice())
					.qty(qty)
					.build();
			
			cartRepository.save(cartLine);
		} else {
			throw new ProductNotFoundException();
		}
		
		return cartLineMapper.toCartLineDto(cartLine);
	}

	@ApiOperation(value = "Supprime un produit du panier")
	public void removeFromCart(String productId) {
			cartRepository.deleteByProductId(productId);
	}

	@ApiOperation(value = "Recupere tout le panier")
	public List<CartLineDto> findAll() {
		return cartRepository.findAll().stream().map(cartLineMapper::toCartLineDto).collect(Collectors.toList());
	}
}
