package ru.vsu.shop.ui.menu.impl;

import org.di.annotation.Autowired;
import ru.vsu.shop.service.logic.ProductService;
import ru.vsu.shop.service.model.ProductDto;
import ru.vsu.shop.ui.menu.ProductMenu;

import java.math.BigDecimal;
import java.util.List;

import static ru.vsu.shop.ui.menu.impl.ConsoleMenu.INPUT;

public class ConsoleProductMenuImpl implements ProductMenu {
  @Autowired
  ProductService productService;

  @Override
  public ProductDto findById() {
    System.out.println("Input product id");

    try {
      Integer id = Integer.valueOf(INPUT.next());
      return productService.findById(id);
    } catch (NumberFormatException ignored) {
      System.out.println("Input is invalid");
      return null;
    }
  }

  @Override
  public ProductDto updateProduct() {
    System.out.println("Input product id, name and price (line by line)");

    try {
      Integer id = Integer.parseInt(INPUT.next());
      String name = INPUT.next();
      BigDecimal price = BigDecimal.valueOf(Integer.parseInt(INPUT.next()));
      return productService.updateProduct(new ProductDto(id, name, price));
    } catch (NumberFormatException ignored) {
      System.out.println("Input is invalid");
      return new ProductDto();
    }
  }

  @Override
  public ProductDto createProduct() {
    System.out.println("Input product name and price (line by line)");

    try {
      String name = INPUT.next();
      BigDecimal price = BigDecimal.valueOf(Integer.parseInt(INPUT.next()));
      return productService.createProduct(new ProductDto(name, price));
    } catch (NumberFormatException ignored) {
      System.out.println("Input is invalid");
      return new ProductDto();
    }
  }

  @Override
  public void deleteById() {
    System.out.println("Input product id");

    try {
      Integer id = Integer.valueOf(INPUT.next());
      productService.deleteById(id);
      System.out.println("Deleted if present");
    } catch (NumberFormatException ignored) {
      System.out.println("Input is invalid");
    }
  }

  @Override
  public List<ProductDto> findByName() {
    System.out.println("Input product name");

    return productService.findByName(INPUT.next());
  }

  @Override
  public List<ProductDto> findAll() {
    return productService.findAll();
  }
}
