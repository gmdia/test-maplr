package com.maplr.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maplr.dto.OrderLineDto;
import com.maplr.dto.OrderValidationResponseDto;
import com.maplr.entity.Order;
import com.maplr.entity.OrderLine;
import com.maplr.repository.OrderRepository;
import com.maplr.service.OrderService;

import io.swagger.annotations.Api;

@Service
@Api(tags = "Service commande")
public class OrderServiceImpl implements OrderService{
	private ProductServiceImpl productService;
	private OrderRepository orderRepository;

	@Autowired
	public OrderServiceImpl(ProductServiceImpl productService, OrderRepository orderRepository) {
		this.productService = productService;
		this.orderRepository = orderRepository;
	}

	@Override
	public OrderValidationResponseDto placeOrder(List<OrderLineDto> orderLines) {
		List<String> invalidProductIds = new ArrayList<>();
		BigDecimal totalPrice = BigDecimal.ZERO;
		for (OrderLineDto orderLine : orderLines) {
			if (productService.productExists(orderLine.getProductId())) {
				totalPrice = totalPrice.add(orderLine.getPrice());
			} else {
				invalidProductIds.add(orderLine.getProductId());
			}
		}

		if (!invalidProductIds.isEmpty()) {
			return OrderValidationResponseDto.builder()
					.valid(false)
					.errors(invalidProductIds)
					.build();
		}

		List<OrderLine> lines = orderLines.stream()
				.map(orderLine -> OrderLine.builder()
						.productId(orderLine.getProductId())
						.quantity(orderLine.getQty()).build())
				.collect(Collectors.toList());

		Order order = Order.builder().orderLines(lines).build();
		orderRepository.save(order);
		return OrderValidationResponseDto.builder().valid(true).total(totalPrice).errors(invalidProductIds).build();
	}
}
