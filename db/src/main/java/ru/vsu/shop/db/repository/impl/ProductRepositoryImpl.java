package ru.vsu.shop.db.repository.impl;

import ru.vsu.shop.db.repository.ProductRepository;
import ru.vsu.shop.db.storage.StorageInMemory;

public class ProductRepositoryImpl implements ProductRepository {
  StorageInMemory storageInMemory;

  public ProductRepositoryImpl() {
    storageInMemory = new StorageInMemory();

    System.out.println("ProductRepositoryImpl");
  }
}
