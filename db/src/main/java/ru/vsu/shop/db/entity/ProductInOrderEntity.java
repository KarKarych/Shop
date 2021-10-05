package ru.vsu.shop.db.entity;

public class ProductInOrderEntity {
  private Integer productId;

  private Integer orderId;

  private Integer productCount;

  public ProductInOrderEntity(Integer productId, Integer orderId, Integer productCount) {
    this.productId = productId;
    this.orderId = orderId;
    this.productCount = productCount;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public Integer getProductCount() {
    return productCount;
  }

  public void setProductCount(Integer productCount) {
    this.productCount = productCount;
  }
}
