package ru.vsu.shop.db.repository.impl;

import ru.vsu.shop.db.entity.ProductEntity;
import ru.vsu.shop.db.repository.ProductRepository;
import ru.vsu.shop.db.storage.StorageInMemory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductRepositoryImpl implements ProductRepository {

  private final List<ProductEntity> products;

  public ProductRepositoryImpl() {
    products = new StorageInMemory().getProducts();
  }

  @Override
  public Optional<ProductEntity> findById(Integer id) {
    return products.stream()
      .filter(product -> id.equals(product.getId()))
      .findAny();
  }

  @Override
  public List<ProductEntity> findByName(String search) {
    return products.stream()
      .filter(product -> search.toLowerCase().contains(product.getName().toLowerCase()))
      .collect(Collectors.toList());
  }

  @Override
  public List<ProductEntity> findAll() {
    return products;
  }

  @Override
  public ProductEntity save(ProductEntity productEntity) {
    var result = products.stream()
      .filter(product -> productEntity.getId().equals(product.getId()))
      .findAny();

    if (result.isPresent()) {
      result.get().setPrice(productEntity.getPrice());
      result.get().setName(productEntity.getName());
    } else {
      products.add(new ProductEntity(products.get(products.size() - 1).getId() + 1,
        productEntity.getName(),
        productEntity.getPrice()));
    }
    return products.get(products.size() - 1);
  }

  @Override
  public void deleteById(Integer id) {
    var result = products.stream()
      .filter(product -> id.equals(product.getId()))
      .findAny();

    result.ifPresent(products::remove);
  }
}
