package ru.vsu.shop.service.logic.impl;

import org.di.annotation.Autowired;
import ru.vsu.shop.db.entity.OrderEntity;
import ru.vsu.shop.db.entity.ProductEntity;
import ru.vsu.shop.db.entity.ProductInOrderEntity;
import ru.vsu.shop.db.repository.OrderRepository;
import ru.vsu.shop.service.logic.OrderService;
import ru.vsu.shop.service.model.OrderDto;
import ru.vsu.shop.service.model.ProductDto;
import ru.vsu.shop.service.model.ProductInOrderDto;
import ru.vsu.shop.service.model.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {
  @Autowired
  OrderRepository orderRepository;

  @Override
  public OrderDto findById(Integer id) {
    var result = orderRepository.findById(id);

    return result
      .map(orderEntity -> new OrderDto(orderEntity.getId(),
        orderEntity.getStatus().getId(),
        orderEntity.getUserId(),
        orderEntity.getProducts().stream().map(product -> new ProductInOrderDto(product.getProductId(),
          product.getOrderId(), product.getProductCount())).collect(Collectors.toList())
      ))
      .orElse(null);
  }

  @Override
  public List<OrderDto> findByUserId(Integer id) {
    return orderRepository.findByUserId(id).stream().map(orderEntity ->
      new OrderDto(orderEntity.getId(),
        orderEntity.getStatus().getId(),
        orderEntity.getUserId(),
        orderEntity.getProducts().stream().map(product -> new ProductInOrderDto(product.getProductId(),
          product.getOrderId(), product.getProductCount())).collect(Collectors.toList()))
    ).collect(Collectors.toList());
  }

  @Override
  public OrderDto createOrder(OrderDto orderDto) {
    var result = orderRepository.save(new OrderEntity(
      orderDto.getStatus(),
      orderDto.getUserId(),
      orderDto.getProducts().stream().map(product -> new ProductInOrderEntity(product.getProductId(),
        product.getOrderId(), product.getProductCount())).collect(Collectors.toList())
    ));

    return new OrderDto(result.getId(), result.getStatus().getId(), result.getUserId(),
      result.getProducts().stream().map(product -> new ProductInOrderDto(product.getProductId(),
        product.getOrderId(), product.getProductCount())).collect(Collectors.toList())
    );
  }

  @Override
  public OrderDto updateOrder(OrderDto orderDto) {
    var result = orderRepository.save(new OrderEntity(
      orderDto.getId(),
      orderDto.getStatus(),
      orderDto.getUserId(),
      orderDto.getProducts().stream().map(product -> new ProductInOrderEntity(product.getProductId(),
        product.getOrderId(), product.getProductCount())).collect(Collectors.toList()))
    );

    return new OrderDto(result.getId(), result.getStatus().getId(), result.getUserId(),
      result.getProducts().stream().map(product -> new ProductInOrderDto(product.getProductId(),
        product.getOrderId(), product.getProductCount())).collect(Collectors.toList())
    );
  }

  @Override
  public void deleteById(Integer id) {
    orderRepository.deleteById(id);
  }
}
