package ru.vsu.shop.db.repository;

import ru.vsu.shop.db.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

  Optional<ProductEntity> findById(Integer id);

  ProductEntity save(ProductEntity productEntity);

  void deleteById(Integer id);

  List<ProductEntity> findByName(String search);

  List<ProductEntity> findAll();
}
