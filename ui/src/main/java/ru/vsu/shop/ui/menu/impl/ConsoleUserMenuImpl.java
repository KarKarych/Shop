package ru.vsu.shop.ui.menu.impl;

import org.di.annotation.Autowired;
import ru.vsu.shop.service.logic.UserService;
import ru.vsu.shop.service.model.UserDto;
import ru.vsu.shop.ui.menu.UserMenu;

import static ru.vsu.shop.ui.menu.impl.ConsoleMenu.INPUT;

public class ConsoleUserMenuImpl implements UserMenu {

  @Autowired
  UserService userService;

  @Override
  public UserDto findById() {
    System.out.println("Input user id");

    try {
      Integer id = Integer.valueOf(INPUT.nextLine());
      return userService.findById(id);
    } catch (NumberFormatException ignored) {
      return null;
    }
  }
}
