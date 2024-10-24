package org.market.infrastructure;

import org.market.Repositories.ProductRepository;
import org.market.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository extends ProductRepository, JpaRepository<Product, Long> {
  
}
