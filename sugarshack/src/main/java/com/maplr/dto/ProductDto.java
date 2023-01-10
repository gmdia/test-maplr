package com.maplr.dto;

import java.math.BigDecimal;

import com.maplr.enumeration.ProductType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * DTO produit
 * @author mamad
 *
 */
@Data
@Builder
@ApiModel(description = "DTO produit")
public class ProductDto {
	/** Id produit */
	@ApiModelProperty(value = "Id produit")
	private String id;

	/** Nom */
	@ApiModelProperty(value = "Nom")
	private String name;

	/** Prix */
	@ApiModelProperty(value = "Prix")
	private BigDecimal price;

	/** Type produit */
	@ApiModelProperty(value = "Type produit")
	private ProductType type;
}
