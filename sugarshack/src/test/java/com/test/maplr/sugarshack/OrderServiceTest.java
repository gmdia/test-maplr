package com.test.maplr.sugarshack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.maplr.dto.OrderLineDto;
import com.maplr.dto.OrderValidationResponseDto;
import com.maplr.repository.OrderRepository;
import com.maplr.service.impl.OrderServiceImpl;
import com.maplr.service.impl.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

	@Mock
	private ProductServiceImpl productService;

	@Mock
	private OrderRepository orderRepository;

	private OrderServiceImpl orderService;

	@BeforeEach
	public void setUp() {
		orderService = new OrderServiceImpl(productService, orderRepository);
	}

	@Test
	public void testPlaceOrder_allValid() {
		// Given
		String productId1 = "123";
		String productId2 = "456";
		OrderLineDto line1 = OrderLineDto.builder()
				.productId(productId1)
				.qty(2)
				.price(BigDecimal.valueOf(10))
				.build();

		OrderLineDto line2 = OrderLineDto.builder()
				.productId(productId2)
				.qty(3)
				.price(BigDecimal.valueOf(20))
				.build();

		List<OrderLineDto> lines = Arrays.asList(line1, line2);

		when(productService.productExists(productId1)).thenReturn(true);
		when(productService.productExists(productId2)).thenReturn(true);

		// When
		OrderValidationResponseDto response = orderService.placeOrder(lines);

		// Then
		assertThat(response.isValid()).isTrue();
		assertThat(response.getErrors()).isEmpty();
		assertThat(response.getTotal()).isEqualTo(BigDecimal.valueOf(30));
	}

	@Test
	public void testPlaceOrder_someInvalid() {
		// Given
		String productId1 = "123";
		String productId2 = "456";
		String productId3 = "789";
		OrderLineDto line1 = OrderLineDto.builder()
				.productId(productId1)
				.qty(2)
				.price(BigDecimal.valueOf(10))
				.build();

		OrderLineDto line2 = OrderLineDto.builder()
				.productId(productId2)
				.qty(3)
				.price(BigDecimal.valueOf(20))
				.build();
		
		OrderLineDto line3 = OrderLineDto.builder()
				.productId(productId3)
				.qty(0)
				.price(BigDecimal.valueOf(1000))
				.build();

		List<OrderLineDto> lines = Arrays.asList(line1, line2, line3);

		when(productService.productExists(productId1)).thenReturn(true);
		when(productService.productExists(productId2)).thenReturn(true);
		when(productService.productExists(productId3)).thenReturn(false);

		// When
		OrderValidationResponseDto response = orderService.placeOrder(lines);

		// Then
		assertFalse(response.isValid());
		assertThat(response.getErrors()).isNotEmpty();
		assertEquals(1, response.getErrors().size());
		assertTrue(response.getErrors().contains(productId3));
	}
}
