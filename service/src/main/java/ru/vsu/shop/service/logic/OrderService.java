package ru.vsu.shop.service.logic;

import ru.vsu.shop.service.model.OrderDto;

import java.util.List;
import java.util.Optional;

public interface OrderService {

  Optional<OrderDto> findById(Integer id);

  List<OrderDto> findByUserId(Integer id);

  OrderDto save(OrderDto orderDto);

  OrderDto update(OrderDto orderDto);

  void deleteById(Integer id);
}
