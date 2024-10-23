package org.market.dtos;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class ProductStockUpdateDTO {

  @NotNull(message = "Stock quantity is required")
  private BigDecimal stockQuantity;

  public BigDecimal getStockQuantity() {
    return stockQuantity;
  }

  public void setStockQuantity(BigDecimal stockQuantity) {
    this.stockQuantity = stockQuantity;
  }
}
