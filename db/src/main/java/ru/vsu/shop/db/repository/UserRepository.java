package ru.vsu.shop.db.repository;

import ru.vsu.shop.db.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

  Optional<UserEntity> findById(Integer id);

  UserEntity save(UserEntity productEntity);

  void deleteById(Integer id);

  List<UserEntity> findByName(String search);

  List<UserEntity> findAll();
}
