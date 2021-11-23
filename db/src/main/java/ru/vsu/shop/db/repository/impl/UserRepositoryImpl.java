package ru.vsu.shop.db.repository.impl;

import ru.vsu.shop.db.entity.UserEntity;
import ru.vsu.shop.db.repository.UserRepository;
import ru.vsu.shop.db.storage.StorageInMemory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.vsu.shop.db.storage.StorageInMemory.USERS;

public class UserRepositoryImpl implements UserRepository {

  private final List<UserEntity> users = USERS;

  public UserRepositoryImpl() {
  }

  @Override
  public Optional<UserEntity> findById(Integer id) {
    return users.stream()
      .filter(user -> id.equals(user.getId()))
      .findAny();
  }

  @Override
  public List<UserEntity> findByName(String search) {
    return users.stream()
      .filter(user -> search.toLowerCase().contains(user.getUsername().toLowerCase()) ||
        search.toLowerCase().contains(user.getName().toLowerCase()))
      .collect(Collectors.toList());
  }

  @Override
  public List<UserEntity> findAll() {
    return users;
  }

  @Override
  public UserEntity save(UserEntity userEntity) {
    var result = users.stream()
      .filter(user -> userEntity.getId().equals(user.getId()))
      .findAny();

    if (result.isPresent()) {
      result.get().setUsername(userEntity.getUsername());
      result.get().setPassword(userEntity.getPassword());
      result.get().setName(userEntity.getName());
    } else {
      users.add(new UserEntity(users.get(users.size() - 1).getId() + 1,
        userEntity.getUsername(),
        userEntity.getName(),
        userEntity.getPassword()));
    }
    return users.get(users.size() - 1);
  }

  @Override
  public void deleteById(Integer id) {
    var result = users.stream()
      .filter(user -> id.equals(user.getId()))
      .findAny();

    result.ifPresent(users::remove);
  }
}
