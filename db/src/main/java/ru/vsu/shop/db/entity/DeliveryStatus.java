package ru.vsu.shop.db.entity;

import java.util.Optional;

public enum DeliveryStatus {
  AT_DISTRIBUTION_POINT(1),
  DELIVERING(2),
  AT_PICKUP_POINT(3),
  DELIVERED(4);

  private final Integer id;

  private static DeliveryStatus[] cachedValues = null;

  DeliveryStatus(Integer id) {
    this.id = id;
  }

  public static Optional<DeliveryStatus> fromId(Integer id) {
    if (cachedValues == null) {
      cachedValues = DeliveryStatus.values();
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
