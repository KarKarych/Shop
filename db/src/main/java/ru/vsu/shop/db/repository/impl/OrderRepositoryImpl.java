package ru.vsu.shop.db.repository.impl;

import ru.vsu.shop.db.entity.OrderEntity;
import ru.vsu.shop.db.repository.OrderRepository;
import ru.vsu.shop.db.storage.StorageInMemory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.vsu.shop.db.storage.StorageInMemory.ORDERS;


public class OrderRepositoryImpl implements OrderRepository {
  private final List<OrderEntity> orders = ORDERS;

  public OrderRepositoryImpl() {
  }

  @Override
  public Optional<OrderEntity> findById(Integer id) {
    return orders.stream()
      .filter(order -> id.equals(order.getId()))
      .findAny();
  }

  @Override
  public List<OrderEntity> findByUserId(Integer id) {
    return orders.stream()
      .filter(order -> order.getUserId().equals(id))
      .collect(Collectors.toList());
  }

  @Override
  public OrderEntity save(OrderEntity orderEntity) {
    var result = orders.stream()
      .filter(order -> orderEntity.getId().equals(order.getId()))
      .findAny();

    if (result.isPresent()) {
      result.get().setStatus(orderEntity.getStatus());
      result.get().setProducts(orderEntity.getProducts());
      result.get().setUserId(orderEntity.getUserId());
    } else {
      orders.add(new OrderEntity(orders.get(orders.size() - 1).getId() + 1,
        orderEntity.getStatus(),
        orderEntity.getUserId(),
        orderEntity.getProducts()));
    }
    return orders.get(orders.size() - 1);
  }

  @Override
  public void deleteById(Integer id) {
    var result = orders.stream()
      .filter(order -> id.equals(order.getId()))
      .findAny();

    result.ifPresent(orders::remove);
  }
}
