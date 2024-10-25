package org.market.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.market.dtos.ProductStockUpdateDTO;
import org.market.products.*;
import org.market.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
  private final ProductService productService;

  ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public List<Product> getAll() {
    return productService.getAllProducts();
  }

  @GetMapping("/{id}")
  public Optional<Product> getProduct(@PathVariable Long id) {
    return productService.getProduct(id);
  }
  
  @PostMapping
  public Product createProduct(@Valid @RequestBody Product product) {
    System.out.println(product);
    return productService.createProduct(product);
  }
  
  @PutMapping("/{id}")
  public Optional<Product> updateProduct(@Valid @RequestBody Product product) {
    return productService.updateProduct(product);
  }
  
  @DeleteMapping("/{id}")
  public void deleteProduct(@PathVariable Long id) {
    productService.deleteProduct(id);
  }

  @PatchMapping("/{id}/update-stock")
  public Optional<Product> updateStock(@PathVariable Long id, 
      @Valid @RequestBody ProductStockUpdateDTO product) {
    return productService.updateStock(id, product);
  }
}