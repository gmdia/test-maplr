package com.maplr.service.impl;

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
import com.maplr.service.CartService;

import io.swagger.annotations.Api;

@Service
@Api(tags = "Service panier")
public class CartServiceImpl implements CartService{
	private final ProductServiceImpl productService;
	private final CartRepository cartRepository;
	private CartLineMapper cartLineMapper;

	@Autowired
	public CartServiceImpl(CartRepository cartRepository, ProductServiceImpl productService, CartLineMapper cartLineMapper) {
		this.cartRepository = cartRepository;
		this.productService = productService;
		this.cartLineMapper = cartLineMapper;
	}

	@Override
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

	@Override
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

	@Override
	public void removeFromCart(String productId) {
			cartRepository.deleteByProductId(productId);
	}

	@Override
	public List<CartLineDto> findAll() {
		return cartRepository.findAll().stream().map(cartLineMapper::toCartLineDto).collect(Collectors.toList());
	}
}
