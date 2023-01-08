package com.maplr.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "orderLine")
@ApiModel(description = "Entite ligne de commande")
public class OrderLine {
	@Id
	@ApiModelProperty(notes = "Id ligne de commande", example = "1")
	private String id;

	@ApiModelProperty(notes = "Id produit", example = "1")
	private String productId;

	@ApiModelProperty(notes = "Quantite", example = "1")
	private int quantity;

	@ManyToOne
	@ApiModelProperty(notes = "Le produit de la ligne de commande")
	private Product product;
}
