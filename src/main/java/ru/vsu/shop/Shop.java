package ru.vsu.shop;

import org.di.Application;
import org.di.ApplicationContext;
import ru.vsu.shop.ui.menu.Menu;

public class Shop {
  private static final String[] packages = new String[]{
    "ru.vsu.shop",
    "ru.vsu.shop.ui",
    "ru.vsu.shop.service",
    "ru.vsu.shop.db",
    "org.di"};

  public static void main(String[] args) {
    ApplicationContext context = Application.run(packages);
    context.getObject(Menu.class).run();
  }
}
