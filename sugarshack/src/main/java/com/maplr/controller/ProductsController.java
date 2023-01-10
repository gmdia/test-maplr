package com.maplr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maplr.dto.CatalogueItemDto;
import com.maplr.enumeration.ProductType;
import com.maplr.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

/**
 * Controler produit
 * @author mamad
 *
 */
@RestController
@RequestMapping("/products/{productId}")
public class ProductsController {
	/** Service produit */
	private final ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * Renvoie une reponse contenant le catalogue produit
	 * @param type : type de produit
	 * @return ResponseEntity<List<CatalogueItemDto>>
	 */
	@GetMapping
	@ApiOperation(value = "renvoie le catalogue produit", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"), 
			@ApiResponse(code = 401, message = "Unauthorized")})
	public ResponseEntity<List<CatalogueItemDto>> getCatalogue(@ApiParam(value = "Le type produit (AMBER, DARK, CLEAR)") ProductType type) {
		List<CatalogueItemDto> catalogueItemDto = productService.getCatalogue(type);
		return ResponseEntity.ok(catalogueItemDto);
	}
}
