package com.maplr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maplr.dto.OrderLineDto;
import com.maplr.dto.OrderValidationResponseDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Service
@Api(tags = "Service commande")
public interface OrderService {
	@ApiOperation(value = "Passe une commande")
	public OrderValidationResponseDto placeOrder(List<OrderLineDto> orderLines);
}
