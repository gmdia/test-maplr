package com.maplr.dto;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * DTO ligne panier
 * @author mamad
 *
 */
@Data
@Builder
@ApiModel(description = "DTO ligne panier")
public class CartLineDto {
	/** Id produit */
	@ApiModelProperty(value = "Id produit")
	private String productId;

	/** Quantite */
	@ApiModelProperty(value = "Quantite")
	private int qty;

	/** Prix */
	@ApiModelProperty(value = "Prix")
	private BigDecimal price;
}
