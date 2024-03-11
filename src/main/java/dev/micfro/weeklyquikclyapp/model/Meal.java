package dev.micfro.weeklyquikclyapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToMany(mappedBy = "meals")
    private List<Customer> customers;

    @ManyToMany(mappedBy = "meals")
    private List<ShoppingOrder> shoppingOrders;

    private String mealName;
    private String mealDescription;

    // to one meal can be added multiple products
    @ManyToMany
    @JoinTable(
            name = "meal_product",  // Name of the join table
            joinColumns = @JoinColumn(name = "meal_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;



}
