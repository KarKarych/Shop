package ru.vsu.shop.service.logic;

import ru.vsu.shop.service.model.UserDto;

import java.util.List;

public interface UserService {
  
  UserDto createUser(UserDto userDto);

  UserDto updateUser(UserDto userDto);

  void deleteById(Integer id);

  UserDto findById(Integer id);

  List<UserDto> findByName(String search);

  List<UserDto> findAll();
}
