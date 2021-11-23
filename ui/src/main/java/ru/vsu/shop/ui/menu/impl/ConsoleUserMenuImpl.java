package ru.vsu.shop.ui.menu.impl;

import org.di.annotation.Autowired;
import ru.vsu.shop.service.logic.UserService;
import ru.vsu.shop.service.model.UserDto;
import ru.vsu.shop.ui.menu.UserMenu;

import java.util.List;

import static ru.vsu.shop.ui.menu.impl.ConsoleMenu.INPUT;

public class ConsoleUserMenuImpl implements UserMenu {

  @Autowired
  UserService userService;

  @Override
  public UserDto createUser() {
    System.out.println("Input username, name, password (line by line)");

    return userService.createUser(new UserDto(INPUT.next(), INPUT.next(), INPUT.next()));
  }

  @Override
  public UserDto updateUser() {
    System.out.println("Input user_id, username, name, password (line by line)");

    try {
      Integer id = Integer.valueOf(INPUT.next());
      return userService.updateUser(new UserDto(id, INPUT.next(), INPUT.next(), INPUT.next()));
    } catch (NumberFormatException ignored) {
      System.out.println("Input is invalid");
      return new UserDto();
    }
  }

  @Override
  public void deleteUserById() {
    System.out.println("Input user id");

    try {
      Integer id = Integer.valueOf(INPUT.next());
      userService.deleteById(id);
      System.out.println("Deleted if present");
    } catch (NumberFormatException ignored) {
      System.out.println("Input is invalid");
    }
  }

  @Override
  public UserDto findById() {
    System.out.println("Input user id");

    try {
      Integer id = Integer.valueOf(INPUT.next());
      return userService.findById(id);
    } catch (NumberFormatException ignored) {
      System.out.println("Input is invalid");
      return null;
    }
  }

  @Override
  public List<UserDto> findByName() {
    System.out.println("Input username");

    return userService.findByName(INPUT.next());
  }

  @Override
  public List<UserDto> findAll() {
    return userService.findAll();
  }
}
