package org.market.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.market.Repositories.ProductRepository;
import org.market.dtos.ProductStockUpdateDTO;
import org.market.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
  @Autowired
  private final ProductRepository productRepository;

  ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product createProduct(Product product) {
    validateProduct(product);
    return productRepository.save(product);
  }

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public Optional<Product> getProduct(Long id) {
    return productRepository.findById(id);
  }
  
  public Optional<Product> updateProduct(Product product) {
    return productRepository.findById(product.getId()).map(existingData -> {
      validateProduct(product);
      return updateData(existingData, product);
    });
  }

  private void validateProduct(Product product) {
    if (product.getPrice().compareTo(BigDecimal.ONE) == -1) {
        throw new IllegalArgumentException("Price must be greater than 1");
    }

    // Check for negative stock quantity
    if (product.getStockQuantity() == null || product.getStockQuantity() < 0) {
        throw new IllegalArgumentException("Stock quantity cannot be negative");
    }
}

  private Product updateData(Product existingData, Product newData) {
    existingData.setName(newData.getName());
    existingData.setPrice(newData.getPrice());
    existingData.setCategory(newData.getCategory());
    existingData.setDescription(newData.getDescription());
    existingData.setStockQuantity(newData.getStockQuantity());
    
    return productRepository.save(existingData);
  }

  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }

  public Optional<Product> updateStock(Long id, ProductStockUpdateDTO product) {
    return productRepository.findById(id).map(existingData -> {
      if (product.getStockQuantity() < 0) {
        throw new IllegalArgumentException("Stock quantity cannot be negative");
      }
      return update(existingData, product);
    });
  }

  private Product update(Product existingData, ProductStockUpdateDTO newData) {
    existingData.setStockQuantity(newData.getStockQuantity());
    
    return productRepository.save(existingData);
  }

}
