package ru.vsu.shop.db.repository;

import ru.vsu.shop.db.entity.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

  Optional<OrderEntity> findById(Integer id);

  List<OrderEntity> findByUserId(Integer id);

  OrderEntity save(OrderEntity productEntity);

  void deleteById(Integer id);
}
