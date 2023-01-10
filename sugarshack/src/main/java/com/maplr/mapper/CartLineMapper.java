package com.maplr.mapper;

import org.mapstruct.Mapper;

import com.maplr.dto.CartLineDto;
import com.maplr.entity.CartLine;

/**
 * Mapper ligne panier
 * @author mamad
 *
 */
@Mapper(componentModel = "spring")
public interface CartLineMapper {
	/**
	 * Mappe CartLine vers CartLineDto
	 * @param cartLine
	 * @return CartLineDto
	 */
	CartLineDto toCartLineDto(CartLine cartLine);
	
	/**
	 * Mappe CartLineDto vers CartLine
	 * @param cartLineDto
	 * @return CartLine
	 */
	CartLine fromCartLineDto(CartLineDto cartLineDto);
}
