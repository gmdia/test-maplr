package com.maplr.dto;

import java.math.BigDecimal;

import com.maplr.enumeration.ProductType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(description = "DTO article catalogue")
public class CatalogueItemDto {
	@ApiModelProperty(value = "Id produit")
	private String id;

	@ApiModelProperty(value = "Nom")
	private String name;

	@ApiModelProperty(value = "Type produit")
	private ProductType type;

	@ApiModelProperty(value = "Prix")
	private BigDecimal price;
}
