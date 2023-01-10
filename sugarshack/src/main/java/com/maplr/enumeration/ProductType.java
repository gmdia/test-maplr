package com.maplr.enumeration;

import java.util.Arrays;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

/**
 * Enum type produit
 * @author mamad
 *
 */
@Getter
@ApiModel(description = "Enum type produit")
public enum ProductType {
	/** Type Amber */
	@ApiModelProperty(value = "Type Amber")
	AMBER("Amber"),

	/** Type Dark */
	@ApiModelProperty(value = "Type Dark")
	DARK("Dark"),

	/** Type Clear */
	@ApiModelProperty(value = "Type Clear")
	CLEAR("Clear");

	/** Libelle */
	@ApiModelProperty(value = "Libelle")
	private String libelle;

	ProductType(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Renvoie l'enum ProductType à partir du libelle
	 * @param libelle : le libelle
	 * @return l'enum ProductType
	 */
	public static ProductType fromLibelle(String libelle) {
		return Arrays.stream(values())
				.filter(type -> type.libelle.equals(libelle)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Libelle non valide : " + libelle));
	}
}
