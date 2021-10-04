package ru.vsu.shop.db.provider.impl;

import org.di.annotation.Autowired;
import ru.vsu.shop.db.provider.ProductProvider;
import ru.vsu.shop.db.repository.ProductRepository;

public class ProductProviderImpl implements ProductProvider {

  @Autowired
  ProductRepository productRepository;

  public ProductProviderImpl() {
    System.out.println("ProductProviderImpl");
  }
}
