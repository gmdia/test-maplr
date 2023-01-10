package com.maplr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maplr.dto.CatalogueItemDto;
import com.maplr.dto.ProductDto;
import com.maplr.enumeration.ProductType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Service produit
 * @author mamad
 *
 */
@Service
@Api(tags = "Service produit")
public interface ProductService {
	/**
	 * Renvoie le catalogue produit
	 * @param type : type de produit
	 * @return List<CatalogueItemDto>
	 */
	@ApiOperation(value = "Renvoie le catalogue produit")
	public List<CatalogueItemDto> getCatalogue(ProductType type);

	/**
	 * Check si le produit exist
	 * @param productId : id produit
	 * @return <true> si produit existe, <false> sinon
	 */
	@ApiOperation(value = "Check si le produit exist")
	public boolean productExists(String productId);

	/**
	 * Renvoie produit par id
	 * @param productId : id produit
	 * @return ProductDto
	 */
	@ApiOperation(value = "Renvoie produit par id")
	public ProductDto getByProductId(String productId);
}
