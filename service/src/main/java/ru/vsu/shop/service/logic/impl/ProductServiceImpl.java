package ru.vsu.shop.service.logic.impl;

import org.di.annotation.Autowired;
import ru.vsu.shop.db.provider.ProductProvider;
import ru.vsu.shop.service.logic.ProductService;

public class ProductServiceImpl implements ProductService {

  @Autowired
  ProductProvider productProvider;

  public ProductServiceImpl() {
    System.out.println("ProductServiceImpl");
  }
}
