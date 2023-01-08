package com.maplr.entity;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "cartLine")
@ApiModel(description = "Entite ligne panier")
public class CartLine {
	@ApiModelProperty(notes = "Id produit")
	private String productId;

	@ApiModelProperty(notes = "Quantite")
	private int qty;

	@ApiModelProperty(notes = "Nom")
	private String name;

	@ApiModelProperty(notes = "Prix")
	private BigDecimal price;
}
