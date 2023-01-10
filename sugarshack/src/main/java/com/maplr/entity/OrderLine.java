package com.maplr.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

/**
 * Entite ligne de commande
 * @author mamad
 *
 */
@Data
@Builder
@Entity
@Table(name = "orderLine")
@ApiModel(description = "Entite ligne de commande")
public class OrderLine {
	/** Id ligne de commande */
	@Id
	@ApiModelProperty(notes = "Id ligne de commande", example = "1")
	private String id;

	/** Id produit */
	@ApiModelProperty(notes = "Id produit", example = "1")
	private String productId;

	/** Quantite */
	@ApiModelProperty(notes = "Quantite", example = "1")
	private int quantity;

	/** Le produit de la ligne de commande */
	@ManyToOne
	@ApiModelProperty(notes = "Le produit de la ligne de commande")
	private Product product;
}
