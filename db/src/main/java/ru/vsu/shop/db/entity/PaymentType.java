package ru.vsu.shop.db.entity;

import java.util.Optional;

public enum PaymentType {
  ;

  private final Integer id;

  private static PaymentType[] cachedValues = null;

  PaymentType(Integer id) {
    this.id = id;
  }

  public static Optional<PaymentType> fromId(Integer id) {
    if (cachedValues == null) {
      cachedValues = PaymentType.values();
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
