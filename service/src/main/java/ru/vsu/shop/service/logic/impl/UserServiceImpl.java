package ru.vsu.shop.service.logic.impl;

import org.di.annotation.Autowired;
import ru.vsu.shop.db.repository.UserRepository;
import ru.vsu.shop.service.logic.UserService;
import ru.vsu.shop.service.model.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
  @Autowired
  UserRepository userRepository;

  @Override
  public UserDto createUser(UserDto userDto) {
    return null;
  }

  @Override
  public UserDto updateUser(UserDto userDto) {
    return null;
  }

  @Override
  public void deleteUserById(Integer id) {
    userRepository.deleteById(id);
  }

  @Override
  public UserDto findById(Integer id) {
    var result = userRepository.findById(id);

    return result
      .map(userEntity -> new UserDto(userEntity.getUsername(), userEntity.getName()))
      .orElse(null);
  }

  @Override
  public List<UserDto> findByName(String search) {
    return userRepository.findByName(search).stream().map(userEntity ->
      new UserDto(userEntity.getId(),
        userEntity.getUsername(),
        userEntity.getPassword(),
        userEntity.getName())).collect(Collectors.toList());
  }

  @Override
  public List<UserDto> findAll() {
    return null;
  }
}
