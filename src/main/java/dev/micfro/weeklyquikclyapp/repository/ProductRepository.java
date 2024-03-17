package dev.micfro.weeklyquikclyapp.repository;

import dev.micfro.weeklyquikclyapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
