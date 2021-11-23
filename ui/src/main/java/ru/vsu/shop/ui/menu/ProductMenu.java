package ru.vsu.shop.ui.menu;

import ru.vsu.shop.service.model.ProductDto;

import java.util.List;

public interface ProductMenu {
  ProductDto findById();

  ProductDto updateProduct();

  ProductDto createProduct();

  void deleteById();

  List<ProductDto> findByName();

  List<ProductDto> findAll();

}
