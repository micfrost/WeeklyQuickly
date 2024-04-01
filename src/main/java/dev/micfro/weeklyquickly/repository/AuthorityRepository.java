package dev.micfro.weeklyquickly.repository;

import dev.micfro.weeklyquickly.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
