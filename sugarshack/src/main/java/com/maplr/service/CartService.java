package com.maplr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maplr.dto.CartLineDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Service
@Api(tags = "Service panier")
public interface CartService {
	@ApiOperation(value = "Ajoute un produit")
	public void addToCart(String productId, int qty);

	@ApiOperation(value = "Modifie la quantite d'un produit")
	public CartLineDto changeQty(String productId, int qty);

	@ApiOperation(value = "Supprime un produit du panier")
	public void removeFromCart(String productId);

	@ApiOperation(value = "Recupere tout le panier")
	public List<CartLineDto> findAll();
}
