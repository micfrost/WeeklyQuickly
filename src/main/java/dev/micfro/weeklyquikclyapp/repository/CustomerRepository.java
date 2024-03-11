package dev.micfro.weeklyquikclyapp.repository;

import dev.micfro.weeklyquikclyapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
