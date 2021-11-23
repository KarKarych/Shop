package ru.vsu.shop.db.entity;

import java.util.List;

public class OrderEntity {
  private Integer id;

  private OrderStatus status;

  private Integer userId;

  private List<ProductInOrderEntity> products;

  public OrderEntity(Integer id, OrderStatus status, Integer userId, List<ProductInOrderEntity> products) {
    this.id = id;
    this.status = status;
    this.userId = userId;
    this.products = products;
  }

  public OrderEntity(OrderStatus status, Integer userId, List<ProductInOrderEntity> products) {
    this.status = status;
    this.userId = userId;
    this.products = products;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public List<ProductInOrderEntity> getProducts() {
    return products;
  }

  public void setProducts(List<ProductInOrderEntity> products) {
    this.products = products;
  }
}
