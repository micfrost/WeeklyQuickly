package dev.micfro.weeklyquickly.repository;

import dev.micfro.weeklyquickly.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
