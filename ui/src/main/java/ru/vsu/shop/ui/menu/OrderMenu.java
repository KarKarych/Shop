package ru.vsu.shop.ui.menu;

import ru.vsu.shop.service.model.OrderDto;

import java.util.List;

public interface OrderMenu {
  OrderDto findById();

  List<OrderDto> findByUserId();

  OrderDto createOrder();

  OrderDto updateOrder();

  void deleteById();
}
