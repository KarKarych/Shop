package ru.vsu.shop.service.model;

public class ProductInOrderDto {
  private Integer productId;

  private Integer orderId;

  private Integer productCount;

  public ProductInOrderDto(Integer productId, Integer orderId, Integer productCount) {
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

  @Override
  public String toString() {
    return "ProductInOrder{" +
      "productId=" + productId +
      ", orderId=" + orderId +
      ", productCount=" + productCount +
      '}';
  }
}
