package com.maplr.dto;

import java.math.BigDecimal;

import com.maplr.enumeration.ProductType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(description = "DTO produit")
public class ProductDto {
	@ApiModelProperty(value = "Id produit")
	private String id;

	@ApiModelProperty(value = "Nom")
	private String name;

	@ApiModelProperty(value = "Prix")
	private BigDecimal price;

	@ApiModelProperty(value = "Type produit")
	private ProductType type;
}
