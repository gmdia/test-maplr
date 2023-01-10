package com.maplr.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maplr.dto.CartLineDto;
import com.maplr.service.CartService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

/**
 * Controler panier
 * @author mamad
 *
 */
@RestController
@RequestMapping("/cart")
public class CartController {
	/** Service panier */
	private final CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	/**
	 * Renvoie une reponse contenant une liste de panier
	 * @return ResponseEntity<List<CartLineDto>>
	 */
	@GetMapping
	@ApiOperation(value = "Renvoie une liste de panier", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 401, message = "Unauthorized")})
	public ResponseEntity<List<CartLineDto>> getCart() {
		List<CartLineDto> cartLineDtos = cartService.findAll();
		return ResponseEntity.ok(cartLineDtos);
	}

	/**
	 * Renvoie une reponse valide si ajout ok
	 * @param productId : id produit
	 * @param qty : quantite
	 * @return ResponseEntity<Void>
	 */
	@PutMapping
	@ApiOperation(value = "Ajoute un produit", produces = "application/json")
	@ApiResponses(value = {@ApiResponse(code = 202, message = "Accepted"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized")})
	public ResponseEntity<Void> addToCart(@ApiParam(value = "Id produit") String productId, @ApiParam(value = "La quantite") int qty) {
		cartService.addToCart(productId, qty);
		return ResponseEntity.accepted().build();
	}

	/**
	 * Renvoie une reponse valide si suppression ok
	 * @param productId : id produit
	 * @return ResponseEntity<Void>
	 */
	@DeleteMapping
	@ApiOperation(value = "Supprime un produit", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 202, message = "Accepted"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized")})
	public ResponseEntity<Void> removeFromCart(@ApiParam(value = "Id produit") String productId) {
		cartService.removeFromCart(productId);
		return ResponseEntity.accepted().build();
	}

	/**
	 * Renvoie une reponse contenant le produit avec la nouvelle quantite
	 * @param productId : id produit
	 * @param newQty : nouvelle quantite
	 * @return ResponseEntity<CartLineDto>
	 */
	@PatchMapping
	@ApiOperation(value = "Modifie la quantite", produces = "application/json")
	@ApiResponses(value = {@ApiResponse(code = 202, message = "Accepted"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized")})
	public ResponseEntity<CartLineDto> changeQty(@ApiParam(value = "Id produit") String productId, @ApiParam(value = "La nouvelle quantite") int newQty) {
		CartLineDto cartLineDto =  cartService.changeQty(productId, newQty);
		return ResponseEntity.ok(cartLineDto);
	}
}
