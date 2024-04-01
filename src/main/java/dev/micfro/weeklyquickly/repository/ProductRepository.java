package dev.micfro.weeklyquickly.repository;

import dev.micfro.weeklyquickly.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
    Product findByName(String productName);
}
