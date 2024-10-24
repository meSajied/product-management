package org.market.dtos;

import jakarta.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

@Service
public class ProductStockUpdateDTO {

  @NotNull(message = "Stock quantity is required")
  private Integer stockQuantity;

  public Integer getStockQuantity() {
    return stockQuantity;
  }

  public void setStockQuantity(Integer stockQuantity) {
    this.stockQuantity = stockQuantity;
  }
}
