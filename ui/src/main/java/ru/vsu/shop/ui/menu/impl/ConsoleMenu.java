package ru.vsu.shop.ui.menu.impl;

import org.di.annotation.Autowired;
import ru.vsu.shop.ui.menu.Menu;
import ru.vsu.shop.ui.menu.OrderMenu;
import ru.vsu.shop.ui.menu.ProductMenu;
import ru.vsu.shop.ui.menu.UserMenu;

import java.util.Scanner;

public class ConsoleMenu implements Menu {
  public static final Scanner INPUT = new Scanner(System.in);


  @Autowired
  private ProductMenu productMenu;

  @Autowired
  private UserMenu userMenu;

  @Autowired
  private OrderMenu orderMenu;

  public ConsoleMenu() {
    System.out.println("1");
  }

  @Override
  public void run() {
    boolean isExit = false;
    while (!isExit) {
      System.out.println("Choose Order, Product, User (1 - 3)");
      Integer id = 0;
      try {
        id = Integer.valueOf(INPUT.next());
      } catch (NumberFormatException ignored) {
        System.out.println("Input is invalid");
        continue;
      }

      switch (id) {
        case 1:
          System.out.println("Choose (1 - 6)");
          try {
            id = Integer.valueOf(INPUT.next());
          } catch (NumberFormatException ignored) {
            System.out.println("Input is invalid");
            continue;
          }

          switch (id) {
            case 1:
              System.out.println(orderMenu.findById());
              break;
            case 2:
              System.out.println(orderMenu.findByUserId());
              break;
            case 3:
              System.out.println(orderMenu.createOrder());
              break;
            case 4:
              System.out.println(orderMenu.updateOrder());
              break;
            case 5:
              orderMenu.deleteById();
              break;
          }
          break;
        case 2:
          System.out.println("Choose (1 - 6)");
          try {
            id = Integer.valueOf(INPUT.next());
          } catch (NumberFormatException ignored) {
            System.out.println("Input is invalid");
            continue;
          }

          switch (id) {
            case 1:
              System.out.println(productMenu.findById());
              break;
            case 2:
              System.out.println(productMenu.findByName());
              break;
            case 3:
              System.out.println(productMenu.findAll());
              break;
            case 4:
              System.out.println(productMenu.createProduct());
              break;
            case 5:
              System.out.println(productMenu.updateProduct());
              break;
            case 6:
              productMenu.deleteById();
              break;
          }
          break;
        case 3:
          System.out.println("Choose (1 - 6)");
          try {
            id = Integer.valueOf(INPUT.next());
          } catch (NumberFormatException ignored) {
            System.out.println("Input is invalid");
            continue;
          }

          switch (id) {
            case 1:
              System.out.println(userMenu.findById());
              break;
            case 2:
              System.out.println(userMenu.findByName());
              break;
            case 3:
              System.out.println(userMenu.findAll());
              break;
            case 4:
              System.out.println(userMenu.createUser());
              break;
            case 5:
              System.out.println(userMenu.updateUser());
              break;
            case 6:
              userMenu.deleteUserById();
              break;
          }
          break;
        default:
      }
    }
  }
}
