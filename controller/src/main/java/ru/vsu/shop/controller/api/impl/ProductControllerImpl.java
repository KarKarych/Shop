package ru.vsu.shop.controller.api.impl;


import org.di.annotation.Autowired;
import ru.vsu.shop.controller.api.ProductController;
import ru.vsu.shop.service.logic.ProductService;

public class ProductControllerImpl implements ProductController {

  @Autowired
  ProductService productService;

  public ProductControllerImpl() {
    System.out.println("ProductControllerImpl");
  }
}
