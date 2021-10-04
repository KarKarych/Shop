package ru.vsu.shop.ui.impl;

import org.di.annotation.Autowired;
import ru.vsu.shop.ui.Menu;
import ru.vsu.shop.ui.ProductMenu;

public class ConsoleMenu implements Menu {

  @Autowired
  ProductMenu productMenu;

  public ConsoleMenu() {
    System.out.println("ConsoleMenu");
  }
}
