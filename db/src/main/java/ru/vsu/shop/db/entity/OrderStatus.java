package ru.vsu.shop.db.entity;

import java.util.Optional;

public enum OrderStatus {
  UNDER_PROCESSING(1),
  PAID(2),
  CLOSED(3);

  private final Integer id;

  private static OrderStatus[] cachedValues = null;

  OrderStatus(Integer id) {
    this.id = id;
  }

  public static Optional<OrderStatus> fromId(Integer id) {
    if (cachedValues == null) {
      cachedValues = OrderStatus.values();
    }

    if (id == null) {
      return Optional.empty();
    }

    for (var value : cachedValues) {
      if (value.id.equals(id)) {
        return Optional.of(value);
      }
    }

    return Optional.empty();
  }

  public Integer getId() {
    return id;
  }
}
