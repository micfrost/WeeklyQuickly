package dev.micfro.weeklyquickly.repository;

import dev.micfro.weeklyquickly.model.CartPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartPositionRepository extends JpaRepository<CartPosition, Long> {
}
