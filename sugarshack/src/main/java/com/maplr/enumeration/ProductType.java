package com.maplr.enumeration;

import java.util.Arrays;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
@ApiModel(description = "Enum type produit")
public enum ProductType {
	@ApiModelProperty(value = "Type Amber")
	AMBER("Amber"),

	@ApiModelProperty(value = "Type Dark")
	DARK("Dark"),

	@ApiModelProperty(value = "Type Clear")
	CLEAR("Clear");

	@ApiModelProperty(value = "Libelle")
	private String libelle;

	ProductType(String libelle) {
		this.libelle = libelle;
	}

	public static ProductType fromLibelle(String libelle) {
		return Arrays.stream(values())
				.filter(type -> type.libelle.equals(libelle)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Libelle non valide : " + libelle));
	}
}
