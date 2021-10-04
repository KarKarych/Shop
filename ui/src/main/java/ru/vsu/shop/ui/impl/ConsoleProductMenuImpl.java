package ru.vsu.shop.ui.impl;

import org.di.annotation.Autowired;
import ru.vsu.shop.controller.api.ProductController;
import ru.vsu.shop.ui.ProductMenu;

public class ConsoleProductMenuImpl implements ProductMenu {

  @Autowired
  ProductController productController;

  public ConsoleProductMenuImpl() {
    System.out.println("ConsoleProductMenuImpl");
  }
}
