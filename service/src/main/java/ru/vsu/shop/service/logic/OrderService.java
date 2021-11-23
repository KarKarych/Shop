package ru.vsu.shop.service.logic;

import ru.vsu.shop.service.model.OrderDto;

import java.util.List;
import java.util.Optional;

public interface OrderService {

  OrderDto findById(Integer id);

  List<OrderDto> findByUserId(Integer id);

  OrderDto createOrder(OrderDto orderDto);

  OrderDto updateOrder(OrderDto orderDto);

  void deleteById(Integer id);
}
