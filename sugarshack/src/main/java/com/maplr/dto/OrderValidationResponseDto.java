package com.maplr.dto;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(description = "DTO reponse validation commande")
public class OrderValidationResponseDto {
	@ApiModelProperty(value = "Total")
	private BigDecimal total;

	@ApiModelProperty(value = "La validite de la commande")
	private boolean valid;

	@ApiModelProperty(value = "Liste de commande en erreur")
	private List<String> errors;
}
