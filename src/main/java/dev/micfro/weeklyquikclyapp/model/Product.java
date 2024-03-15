package dev.micfro.weeklyquikclyapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long categoryID; // ID of the category to which the product belongs

    private String subcategory;

    private String description;

    private String imageUrl;

    private Long quantityInInventory; // Sum of all quantities of items in stock and valid and expired
    private Long quantityValid; // Sum of all quantities of valid items, not expired
    private Long quantityExpired;
    private Long quantitySold;
    private Long quantityReturned;

    private Long quantityLevelToRestock;
    private Long quantityLevelToOffer;


    private double priceProducer;

    private double priceRetail;

    private double weight;
    private double volume;

    private double spaceRequiredOneItem;

    private double spaceOccupiedAllItemsInInventory;
 <>
    private double spaceOccupiedAllItemsValid;

    private double spaceOccupiedAllItemsExpired;

    // added by
    private EmployeeInventrory addedBy;
    private LocalDateTime addedByDateTime;









    // CONSTRUCTOR


    // GETTERS AND SETTERS


}
