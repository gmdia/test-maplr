package com.maplr.entity;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

/**
 * Entite produit
 * @author mamad
 *
 */
@Data
@Builder
@Entity
@Table(name = "product")
@ApiModel(description = "Entite produit")
public class Product {
	/** Id produit */
	@Id
	@ApiModelProperty(value = "Id produit")
	private String id;

	/** Nom */
	@ApiModelProperty(value = "Nom")
	private String name;

	/** Prix */
	@ApiModelProperty(value = "Prix")
	private BigDecimal price;

	/** Type */
	@ApiModelProperty(value = "Type")
	private String type;
}
