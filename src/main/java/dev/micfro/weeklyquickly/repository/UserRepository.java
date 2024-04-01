package dev.micfro.weeklyquickly.repository;

import dev.micfro.weeklyquickly.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
