package ru.vsu.shop.db.entity;

import java.util.Optional;

public enum Role {
  USER(1),
  UNREGISTERED_USER(2);

  private final Integer id;

  private static Role[] cachedValues = null;

  Role(Integer id) {
    this.id = id;
  }

  public static Optional<Role> fromId(Integer id) {
    if (cachedValues == null) {
      cachedValues = Role.values();
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
