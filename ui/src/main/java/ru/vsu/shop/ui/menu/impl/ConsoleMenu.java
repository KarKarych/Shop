package ru.vsu.shop.ui.menu.impl;

import org.di.annotation.Autowired;
import ru.vsu.shop.ui.menu.Menu;
import ru.vsu.shop.ui.menu.ProductMenu;
import ru.vsu.shop.ui.menu.UserMenu;

import java.util.Scanner;

public class ConsoleMenu implements Menu {
  public static final Scanner INPUT = new Scanner(System.in);

  @Autowired
  ProductMenu productMenu;

  @Autowired
  UserMenu userMenu;

  public ConsoleMenu() {

  }

  @Override
  public void run() {
    while (true) {
      var result = userMenu.findById();
      if (result != null)
        System.out.println(result);
      else
        System.out.println("Error");
    }
  }
}
