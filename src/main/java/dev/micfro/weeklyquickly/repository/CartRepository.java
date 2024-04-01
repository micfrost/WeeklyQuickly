package dev.micfro.weeklyquickly.repository;

import dev.micfro.weeklyquickly.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
