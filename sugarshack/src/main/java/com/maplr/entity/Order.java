package com.maplr.entity;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "order")
@ApiModel(description = "Entite commande")
public class Order {
	@Id
	@ApiModelProperty(notes = "Id commande", example = "1")
	private String id;

	@ApiModelProperty(notes = "Id client", example = "1")
	private String customerId;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@ApiModelProperty(notes = "Liste de commande")
	private List<OrderLine> orderLines;

	@ApiModelProperty(value = "Prix total")
	private BigDecimal totalPrice;
}
