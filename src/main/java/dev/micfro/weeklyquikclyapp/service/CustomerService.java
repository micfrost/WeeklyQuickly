package dev.micfro.weeklyquikclyapp.service;

import dev.micfro.weeklyquikclyapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // CRUD operations

    // Create

    // Read

    // Update

    // Delete


}
