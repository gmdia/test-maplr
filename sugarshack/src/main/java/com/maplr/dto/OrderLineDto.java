package com.maplr.dto;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(description = "DTO ligne de commande")
public class OrderLineDto {
	@ApiModelProperty(value = "Id produit")
	private String productId;

	@ApiModelProperty(value = "Quantite")
	private int qty;

	@ApiModelProperty(value = "Prix")
	private BigDecimal price;
}
