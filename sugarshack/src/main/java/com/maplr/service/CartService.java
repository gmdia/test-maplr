package com.maplr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maplr.dto.CartLineDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Service panier
 * @author mamad
 *
 */
@Service
@Api(tags = "Service panier")
public interface CartService {
	/**
	 * Ajoute un produit
	 * @param productId : id produit
	 * @param qty : quantite
	 */
	@ApiOperation(value = "Ajoute un produit")
	public void addToCart(String productId, int qty);

	/**
	 * Modifie la quantite d'un produit
	 * @param productId : id produit
	 * @param qty : quantite
	 * @return CartLineDto
	 */
	@ApiOperation(value = "Modifie la quantite d'un produit")
	public CartLineDto changeQty(String productId, int qty);

	/**
	 * Supprime un produit du panier
	 * @param productId : id produit
	 */
	@ApiOperation(value = "Supprime un produit du panier")
	public void removeFromCart(String productId);

	/**
	 * Recupere tout le panier 
	 * @return List<CartLineDto>
	 */
	@ApiOperation(value = "Recupere tout le panier")
	public List<CartLineDto> findAll();
}
