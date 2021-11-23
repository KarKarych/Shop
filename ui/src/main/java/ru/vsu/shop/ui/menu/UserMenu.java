package ru.vsu.shop.ui.menu;

import ru.vsu.shop.service.model.UserDto;

import java.util.List;

public interface UserMenu {
  UserDto createUser();

  UserDto updateUser();

  void deleteUserById();

  UserDto findById();

  List<UserDto> findByName();

  List<UserDto> findAll();
}
