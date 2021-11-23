package ru.vsu.shop.service.logic.impl;

import org.di.annotation.Autowired;
import ru.vsu.shop.db.entity.OrderStatus;
import ru.vsu.shop.db.entity.ProductInOrderEntity;
import ru.vsu.shop.db.entity.UserEntity;
import ru.vsu.shop.db.repository.UserRepository;
import ru.vsu.shop.service.logic.UserService;
import ru.vsu.shop.service.model.OrderDto;
import ru.vsu.shop.service.model.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDto createUser(UserDto userDto) {
    var result = userRepository.save(new UserEntity(userDto.getUsername(),
      userDto.getName(),
      userDto.getPassword()));

    return new UserDto(result.getId(), result.getUsername(), result.getName(), result.getPassword());
  }

  @Override
  public UserDto updateUser(UserDto userDto) {
    var result = userRepository.save(new UserEntity(
      userDto.getId(),
      userDto.getUsername(),
      userDto.getName(),
      userDto.getPassword()));

    return new UserDto(result.getId(),
      result.getUsername(),
      result.getName(),
      result.getPassword());
  }

  @Override
  public void deleteById(Integer id) {
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
        userEntity.getName())).collect(Collectors.toList());
  }

  @Override
  public List<UserDto> findAll() {
    return userRepository.findAll().stream().map(userEntity ->
      new UserDto(userEntity.getId(),
        userEntity.getUsername(),
        userEntity.getName())).collect(Collectors.toList());
  }
}
