package com.maplr.dto;

import java.math.BigDecimal;

import com.maplr.enumeration.ProductType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * DTO article catalogue
 * @author mamad
 *
 */
@Data
@Builder
@ApiModel(description = "DTO article catalogue")
public class CatalogueItemDto {
	/** Id produit */
	@ApiModelProperty(value = "Id produit")
	private String id;

	/** Nom */
	@ApiModelProperty(value = "Nom")
	private String name;

	/** Type produit */
	@ApiModelProperty(value = "Type produit")
	private ProductType type;

	/** Prix */
	@ApiModelProperty(value = "Prix")
	private BigDecimal price;
}
