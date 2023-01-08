package com.maplr.mapper;

import org.mapstruct.Mapper;

import com.maplr.dto.CartLineDto;
import com.maplr.entity.CartLine;

@Mapper(componentModel = "spring")
public interface CartLineMapper {
	CartLineDto toCartLineDto(CartLine cartLine);
	CartLine fromCartLineDto(CartLineDto cartLineDto);
}
