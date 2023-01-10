package com.maplr.entity;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

/**
 * Entite ligne panier
 * @author mamad
 *
 */
@Data
@Builder
@Entity
@Table(name = "cartLine")
@ApiModel(description = "Entite ligne panier")
public class CartLine {
	/** Id produit */
	@ApiModelProperty(notes = "Id produit")
	private String productId;

	/** Quantite */
	@ApiModelProperty(notes = "Quantite")
	private int qty;

	/** Nom */
	@ApiModelProperty(notes = "Nom")
	private String name;

	/** Prix */
	@ApiModelProperty(notes = "Prix")
	private BigDecimal price;
}
