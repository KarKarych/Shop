package ru.vsu.shop.db.storage;

import ru.vsu.shop.db.entity.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StorageInMemory {
  public final static List<OrderEntity> ORDERS = new ArrayList<>() {
    {
      add(new OrderEntity(1, OrderStatus.CART, 3,
        new ArrayList<>() {{
          add(new ProductInOrderEntity(1, 1, 3));
          add(new ProductInOrderEntity(3, 1, 2));
        }}));
      add(new OrderEntity(2, OrderStatus.UNDER_PROCESSING, 1,
        new ArrayList<>() {{
          add(new ProductInOrderEntity(2, 2, 5));
          add(new ProductInOrderEntity(3, 2, 1));
        }}));
      add(new OrderEntity(3, OrderStatus.CLOSED, 2,
        new ArrayList<>() {{
          add(new ProductInOrderEntity(2, 3, 4));
          add(new ProductInOrderEntity(1, 3, 4));
        }}));
    }
  };

  public final static List<ProductEntity> PRODUCTS = new ArrayList<>() {
    {
      add(new ProductEntity(1, "Stroncium", BigDecimal.valueOf(6)));
      add(new ProductEntity(2, "Bread", BigDecimal.valueOf(2)));
      add(new ProductEntity(3, "Milk", BigDecimal.valueOf(8)));
    }
  };

  public final static List<UserEntity> USERS = new ArrayList<>() {
    {
      add(new UserEntity(1, "averagestudent", "Oleg", "password"));
      add(new UserEntity(2, "mama_karma", "Valentine", "root"));
      add(new UserEntity(3, "tea_baggins", "Hola", "123"));
    }
  };
}
