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

/**
 * Entite commande
 * @author mamad
 *
 */
@Data
@Builder
@Entity
@Table(name = "order")
@ApiModel(description = "Entite commande")
public class Order {
	/** Id commande */
	@Id
	@ApiModelProperty(notes = "Id commande", example = "1")
	private String id;

	/** Id client */
	@ApiModelProperty(notes = "Id client", example = "1")
	private String customerId;

	/** Liste de commande */
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@ApiModelProperty(notes = "Liste de commande")
	private List<OrderLine> orderLines;

	/** Prix total */
	@ApiModelProperty(value = "Prix total")
	private BigDecimal totalPrice;
}
