package ru.vsu.shop.db.entity;

import java.math.BigDecimal;

public class ProductEntity {
  private Integer id;

  private String name;

  private BigDecimal price;

  public ProductEntity(Integer id, String name, BigDecimal price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public ProductEntity(String name, BigDecimal price) {
    this.name = name;
    this.price = price;
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
}
