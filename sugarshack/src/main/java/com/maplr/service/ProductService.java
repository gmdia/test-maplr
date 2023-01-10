package com.maplr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maplr.dto.CatalogueItemDto;
import com.maplr.dto.ProductDto;
import com.maplr.enumeration.ProductType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Service
@Api(tags = "Service produit")
public interface ProductService {
	@ApiOperation(value = "Recupere le catalogue produit")
	public List<CatalogueItemDto> getCatalogue(ProductType type);

	@ApiOperation(value = "Check si le produit exist")
	public boolean productExists(String productId);

	@ApiOperation(value = "Recupere produit par id")
	public ProductDto getByProductId(String productId);
}
