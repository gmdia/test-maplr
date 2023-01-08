package com.maplr.entity;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "product")
@ApiModel(description = "Entite produit")
public class Product {
	@Id
	@ApiModelProperty(value = "Id produit")
	private String id;

	@ApiModelProperty(value = "Nom")
	private String name;

	@ApiModelProperty(value = "Prix")
	private BigDecimal price;

	@ApiModelProperty(value = "Type")
	private String type;
}
