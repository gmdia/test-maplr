package com.maplr.dto;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * DTO reponse validation commande
 * @author mamad
 *
 */
@Data
@Builder
@ApiModel(description = "DTO reponse validation commande")
public class OrderValidationResponseDto {
	/** Total */
	@ApiModelProperty(value = "Total")
	private BigDecimal total;

	/** La validite de la commande */
	@ApiModelProperty(value = "La validite de la commande")
	private boolean valid;

	/** Liste de commande en erreur */
	@ApiModelProperty(value = "Liste de commande en erreur")
	private List<String> errors;
}
