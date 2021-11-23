package ru.vsu.shop.service.logic.impl;

import org.di.annotation.Autowired;
import ru.vsu.shop.db.entity.ProductEntity;
import ru.vsu.shop.db.entity.UserEntity;
import ru.vsu.shop.db.repository.ProductRepository;
import ru.vsu.shop.service.logic.ProductService;
import ru.vsu.shop.service.model.ProductDto;
import ru.vsu.shop.service.model.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public ProductDto findById(Integer id) {
    var result = productRepository.findById(id);

    return result
      .map(productEntity -> new ProductDto(productEntity.getId(),
        productEntity.getName(),
        productEntity.getPrice()))
      .orElse(null);
  }

  @Override
  public ProductDto updateProduct(ProductDto productDto) {
    var result = productRepository.save(new ProductEntity(productDto.getId(),
      productDto.getName(),
      productDto.getPrice()));

    return new ProductDto(result.getId(), result.getName(), result.getPrice());
  }

  @Override
  public ProductDto createProduct(ProductDto productDto) {
    var result = productRepository.save(new ProductEntity(
      productDto.getName(),
      productDto.getPrice()));

    return new ProductDto(result.getId(), result.getName(), result.getPrice());
  }

  @Override
  public void deleteById(Integer id) {
    productRepository.deleteById(id);
  }

  @Override
  public List<ProductDto> findByName(String search) {
    return productRepository.findByName(search).stream().map(productEntity ->
      new ProductDto(productEntity.getId(),
        productEntity.getName(),
        productEntity.getPrice())).collect(Collectors.toList());
  }

  @Override
  public List<ProductDto> findAll() {
    return productRepository.findAll().stream().map(userEntity ->
      new ProductDto(userEntity.getId(),
        userEntity.getName(),
        userEntity.getPrice())).collect(Collectors.toList());
  }
}
