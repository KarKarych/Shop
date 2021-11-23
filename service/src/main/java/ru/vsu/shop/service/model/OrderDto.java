package ru.vsu.shop.service.model;

import ru.vsu.shop.db.entity.OrderStatus;
import ru.vsu.shop.db.entity.ProductInOrderEntity;

import java.util.List;

public class OrderDto {
  private Integer id;

  private OrderStatus status;

  private Integer userId;

  private List<ProductInOrderDto> products;

  private final boolean isEmpty;

  public OrderDto() {
    isEmpty = true;
  }

  public OrderDto(Integer id, Integer status, Integer userId, List<ProductInOrderDto> products) {
    this.id = id;

    if (OrderStatus.fromId(status).isPresent()) {
      this.status = OrderStatus.fromId(status).get();
    }

    this.userId = userId;
    this.products = products;
    isEmpty = false;
  }

  public OrderDto(Integer status, Integer userId, List<ProductInOrderDto> products) {
    if (OrderStatus.fromId(status).isPresent()) {
      this.status = OrderStatus.fromId(status).get();
    }

    this.userId = userId;
    this.products = products;
    isEmpty = false;
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

  public List<ProductInOrderDto> getProducts() {
    return products;
  }

  public void setProducts(List<ProductInOrderDto> products) {
    this.products = products;
  }

  public boolean isEmpty() {
    return isEmpty;
  }

  @Override
  public String toString() {
    StringBuilder productsString = new StringBuilder();

    for (ProductInOrderDto product : products) {
      productsString.append(product.toString()).append("\n");
    }

    return "OrderDto{" +
      "status=" + status +
      ", userId=" + userId +
      ", products=" + productsString +
      '}';
  }
}
