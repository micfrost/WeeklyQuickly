package dev.micfro.weeklyquikclyapp.model;


// Category groups 10 Main groups: FRUITS, VEGETABLES, MEAT, DAIRY, BAKERY, DRINKS, SNACKS, HOUSEHOLD, PERSONAL_CARE, OTHER
// Each group has subcategories
// Each subcategory has products
// Each product has items
// Each item has a delivery
// Each delivery has a route
// Each route has a vehicle
// Each vehicle has a driver
// Each driver has a customer
// Each customer has an order
// Each order has items
// Each item has a product
// Each product has a category
// Each category has a group
// Each group has subcategories
// Each subcategory has products

// Each group has subcategories

// Fruits
// Berries
// Apples
// Citrus
// Stone fruits

// Vegetables
// Leafy greens
// Cruciferous
// Root vegetables
// Squash

// Meat
// Beef
// Pork
// Poultry
// Fish

// Dairy
// Milk
// Cheese
// Yogurt
// Butter
// Cream

// Bakery
// Bread
// Pastries
// Cakes
// Cookies

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

import java.util.List;

@Entity
public class Category {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;


    @ManyToOne()
    private CategoryGroup group;

    @Size(max = 50, message = "Description should not exceed 50 characters")
    private String description;

    @URL(message = "Invalid image URL format")
    private String imageUrl;


    // methods



    // Constructor
    public Category() {
    }

    public Category(Long id, String name, List<Product> products, CategoryGroup group, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.products = products;
        this.group = group;
        this.description = description;
        this.imageUrl = imageUrl;
    }
// toString

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                ", group=" + group +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public CategoryGroup getGroup() {
        return group;
    }

    public void setGroup(CategoryGroup group) {
        this.group = group;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
