package ru.vsu.shop.service.logic;

import ru.vsu.shop.service.model.ProductDto;
import ru.vsu.shop.service.model.UserDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {

  Optional<ProductDto> findById(Integer id);

  ProductDto updateProduct(ProductDto productDto);

  ProductDto updateProduct(UserDto userDto);

  void deleteById(Integer id);

  List<ProductDto> findByName(String search);

  List<ProductDto> findAll();
}
