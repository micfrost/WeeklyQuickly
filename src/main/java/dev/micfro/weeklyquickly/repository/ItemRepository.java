package dev.micfro.weeklyquickly.repository;

import dev.micfro.weeklyquickly.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
