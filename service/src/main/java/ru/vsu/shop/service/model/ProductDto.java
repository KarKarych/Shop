package ru.vsu.shop.service.model;

import java.math.BigDecimal;

public class ProductDto {
  private Integer id;

  private String name;

  private BigDecimal price;

  private final boolean isEmpty;

  public ProductDto() {
    isEmpty = true;
  }

  public ProductDto(Integer id, String name, BigDecimal price) {
    this.id = id;
    this.name = name;
    this.price = price;
    isEmpty = false;
  }

  public ProductDto(String name, BigDecimal price) {
    this.name = name;
    this.price = price;
    isEmpty = false;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public boolean isEmpty() {
    return isEmpty;
  }

  @Override
  public String toString() {
    return "ProductDto{" +
      "name='" + name + '\'' +
      ", price=" + price +
      '}';
  }
}
