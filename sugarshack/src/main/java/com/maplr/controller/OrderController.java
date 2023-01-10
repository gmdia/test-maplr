package com.maplr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maplr.dto.OrderLineDto;
import com.maplr.dto.OrderValidationResponseDto;
import com.maplr.service.OrderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

/**
 * Controler commande
 * @author mamad
 *
 */
@RestController
@RequestMapping("/order")
public class OrderController {
	/** Service commande */
	private final OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	/**
	 * Renvoie une reponse avec la commande valide
	 * @param lines : liste de commandes
	 * @return ResponseEntity<OrderValidationResponseDto>
	 */
	@PostMapping
	@ApiOperation(value = "Passe une commande", consumes = "application/json", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized")})
	public ResponseEntity<OrderValidationResponseDto> placeOrder(@ApiParam(value = "Ligne de commande", required = true) List<OrderLineDto> lines) {
		OrderValidationResponseDto orderValidationResponseDto = orderService.placeOrder(lines);
		return ResponseEntity.ok(orderValidationResponseDto);
	}
}
