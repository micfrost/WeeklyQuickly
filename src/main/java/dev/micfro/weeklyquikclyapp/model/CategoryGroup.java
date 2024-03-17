package dev.micfro.weeklyquikclyapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Set;

// main groups of categories of grocery shop products: (not in capital letters, only first letter is capital)
// Fruits, Vegetables, Meat, Dairy, Bakery, Drinks, Snacks, Household, Personal care, other

@Entity
public class CategoryGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Group name is required")
    private String name;

    @Size(max = 50, message = "Description should not exceed 50 characters")
    private String description;

    @OneToMany(mappedBy = "group")
    private Set<Category> categories;

    // Constructors

    // toString

    // Getters and Setters
}