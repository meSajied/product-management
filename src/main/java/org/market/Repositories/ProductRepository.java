package org.market.Repositories;

import java.util.List;
import java.util.Optional;

import org.market.products.Product;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public interface ProductRepository {
  Product save(Product product);
  List<Product> findAll();
  Optional<Product> findById(Long id);
  void deleteById(Long id);
}
