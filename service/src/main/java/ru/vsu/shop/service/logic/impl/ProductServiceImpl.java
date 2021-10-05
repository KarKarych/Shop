package ru.vsu.shop.service.logic.impl;

import org.di.annotation.Autowired;
import ru.vsu.shop.db.repository.ProductRepository;
import ru.vsu.shop.service.logic.ProductService;
import ru.vsu.shop.service.model.ProductDto;
import ru.vsu.shop.service.model.UserDto;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

  @Autowired
  ProductRepository productRepository;

  public ProductServiceImpl() {
    System.out.println("ProductServiceImpl");
  }

  @Override
  public Optional<ProductDto> findById(Integer id) {
    return Optional.empty();
  }

  @Override
  public ProductDto updateProduct(ProductDto productDto) {
    return null;
  }

  @Override
  public ProductDto updateProduct(UserDto userDto) {
    return null;
  }

  @Override
  public void deleteById(Integer id) {

  }

  @Override
  public List<ProductDto> findByName(String search) {
    return null;
  }

  @Override
  public List<ProductDto> findAll() {
    return null;
  }
}
