package com.chandramani.eCommerce.service.Order;

import com.chandramani.eCommerce.dto.OrderDto;
import com.chandramani.eCommerce.model.Order;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.List;

public interface IOrderService {

    Order placeOrder(Long userId);
    OrderDto getOrder(Long orderId);
    List<OrderDto> getUserOrders(Long userId);

    OrderDto convertToDto(Order order);
}
