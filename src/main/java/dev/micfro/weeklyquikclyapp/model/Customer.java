package dev.micfro.weeklyquikclyapp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Entity
public class Customer extends User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // USER DETAILS
    @OneToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    // Food  preferences
    private boolean isVegetarian;

    private boolean isVegan;

    private boolean isGlutenFree;

    private boolean isLactoseFree;

    private boolean isDiabetic;

    private boolean isAllergicToNuts;


    // Persons in household
    private Integer numberOfPersonsInHousehold;


    // Budget preferences
    private BigDecimal BudgetPerWeekPerFamily;

    private BigDecimal BudgetPerWeekPerPerson;

    private BigDecimal BudgetPerMealPerFamily;

    private BigDecimal BudgetPerMealPerPerson;


    // Delivery preferences
    private LocalTime deliveryTime;
    private LocalDate deliveryDay;
    @Enumerated(EnumType.STRING)
    private DeliveryFrequency deliveryFrequency; // ENUM


    // Marketing preferences
    private boolean isAcceptingMarketingEmails;
    private boolean isAcceptingMarketingTexts;


    // Payment preferences
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private String paypalEmail;


    // Purchase history
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<ShoppingOrder> shoppingOrders;

    @ElementCollection
    private List<Long> orderIds;

    @ManyToMany
    @JoinTable(
            name = "customer_meal",  // Name of the join table
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id")
    )
    private List<Meal> meals;


    @ElementCollection
    private List<Long> mealIds;

    private BigDecimal totalAmountSpent;
    private Integer totalOrders;
    private Integer totalMealsOrdered;

//private Integer totalMealsDelivered;
//private Integer totalMealsCancelled;
//private Integer totalMealsReturned;
//private Integer totalMealsRefunded;

    // CONSTRUCTOR

    public Customer() {
    }

    // TO STRING

    // GETTERS AND SETTERS


}
