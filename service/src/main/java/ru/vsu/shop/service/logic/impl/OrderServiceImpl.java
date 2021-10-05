package ru.vsu.shop.service.logic.impl;

import ru.vsu.shop.service.logic.OrderService;
import ru.vsu.shop.service.model.OrderDto;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {
  @Override
  public Optional<OrderDto> findById(Integer id) {
    return Optional.empty();
  }

  @Override
  public List<OrderDto> findByUserId(Integer id) {
    return null;
  }

  @Override
  public OrderDto save(OrderDto orderDto) {
    return null;
  }

  @Override
  public OrderDto update(OrderDto orderDto) {
    return null;
  }

  @Override
  public void deleteById(Integer id) {

  }
}
