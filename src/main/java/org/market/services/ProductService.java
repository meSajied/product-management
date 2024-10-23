package org.market.services;

import java.util.List;
import java.util.Optional;

import org.market.Repositories.ProductRepository;
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
      return updateData(existingData, product);
    });
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

  public Optional<Product> updateStock(Product product) {
    return productRepository.findById(product.getId()).map(existingData -> {
      return update(existingData, product);
    });
  }

  private Product update(Product existingData, Product newData) {
    existingData.setStockQuantity(newData.getStockQuantity());
    
    return productRepository.save(existingData);
  }

}
