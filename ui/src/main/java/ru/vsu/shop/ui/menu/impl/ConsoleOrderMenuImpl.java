package ru.vsu.shop.ui.menu.impl;

import org.di.annotation.Autowired;
import ru.vsu.shop.service.logic.OrderService;
import ru.vsu.shop.service.logic.UserService;
import ru.vsu.shop.service.model.OrderDto;
import ru.vsu.shop.service.model.ProductDto;
import ru.vsu.shop.service.model.ProductInOrderDto;
import ru.vsu.shop.ui.menu.OrderMenu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static ru.vsu.shop.ui.menu.impl.ConsoleMenu.INPUT;

public class ConsoleOrderMenuImpl implements OrderMenu {
  @Autowired
  OrderService orderService;

  @Override
  public OrderDto findById() {
    System.out.println("Input order id");

    try {
      Integer id = Integer.valueOf(INPUT.next());
      return orderService.findById(id);
    } catch (NumberFormatException ignored) {
      System.out.println("Input is invalid");
      return null;
    }
  }

  @Override
  public List<OrderDto> findByUserId() {
    System.out.println("Input user id");

    try {
      Integer id = Integer.valueOf(INPUT.next());
      return orderService.findByUserId(id);
    } catch (NumberFormatException ignored) {
      System.out.println("Input is invalid");
      return null;
    }
  }

  @Override
  public OrderDto createOrder() {
    System.out.println("Input user_id (line by line)");

    try {
      Integer userId = Integer.parseInt(INPUT.next());
      boolean isExit = false;
      List<ProductInOrderDto> productsInOrder = new ArrayList<>();
      while (!isExit) {
        System.out.println("Input product_id order_id product_count (line by line) If you want exit, input -1");
        int check = Integer.parseInt(INPUT.next());

        if (check == -1) {
          isExit = true;
        }

        Integer productId = Integer.parseInt(INPUT.next());
        Integer orderId = Integer.parseInt(INPUT.next());
        Integer productCount = Integer.parseInt(INPUT.next());

        productsInOrder.add(new ProductInOrderDto(productId, orderId, productCount));

      }
      return orderService.createOrder(new OrderDto(1, userId, productsInOrder));
    } catch (NumberFormatException ignored) {
      System.out.println("Input is invalid");
      return null;
    }
  }

  @Override
  public OrderDto updateOrder() {
    System.out.println("Input order_id user_id (line by line)");

    try {
      Integer orderId = Integer.parseInt(INPUT.next());
      Integer userId = Integer.parseInt(INPUT.next());

      boolean isExit = false;
      List<ProductInOrderDto> productsInOrder = new ArrayList<>();
      while (!isExit) {
        System.out.println("Input product_id order_id product_count (line by line) If you want exit, input -1");
        int check = Integer.parseInt(INPUT.next());

        if (check == -1) {
          isExit = true;
        }

        Integer productId = Integer.parseInt(INPUT.next());
        Integer productCount = Integer.parseInt(INPUT.next());

        productsInOrder.add(new ProductInOrderDto(productId, orderId, productCount));

      }
      return orderService.createOrder(new OrderDto(orderId, 1, userId, productsInOrder));
    } catch (NumberFormatException ignored) {
      System.out.println("Input is invalid");
      return null;
    }
  }

  @Override
  public void deleteById() {
    System.out.println("Input order id");

    try {
      Integer id = Integer.valueOf(INPUT.next());
      orderService.deleteById(id);
      System.out.println("Deleted if present");
    } catch (NumberFormatException ignored) {
      System.out.println("Input is invalid");
    }
  }
}
