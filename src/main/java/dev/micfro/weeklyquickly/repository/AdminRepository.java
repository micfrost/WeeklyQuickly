package dev.micfro.weeklyquickly.repository;

import dev.micfro.weeklyquickly.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
