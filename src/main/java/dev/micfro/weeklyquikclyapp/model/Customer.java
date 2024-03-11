package dev.micfro.weeklyquikclyapp.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // USER DETAILS


    // Food preferences
    private boolean isVegetarian;
    private boolean isVegan;
    private boolean isGlutenFree;
    private boolean isLactoseFree;
    private boolean isDiabetic;
    private boolean isAllergicToNuts;

    // Family details
    private Integer numberOfChildren;
    private Integer numberOfAdults;

    // Budget details
    private Double BudgetPerWeekPerFamily;
    private Double BudgetPerWeekPerPerson;
    private Double BudgetPerMealPerFamily;
    private Double BudgetPerMealPerPerson;

    // Delivery details
    private String deliveryTime;
    private String deliveryDay;
    private String deliveryFrequency;

    // Marketing preferences
    private boolean isAcceptingMarketingEmails;
    private boolean isAcceptingMarketingTexts;

    // Payment details
    private String paymentMethod;  //ENUM
    private String paypalEmail;


    // Purchase history details
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

    private Double totalAmountSpent;
    private Integer totalOrders;
    private Integer totalMealsOrdered;

//private Integer totalMealsDelivered;
//private Integer totalMealsCancelled;
//private Integer totalMealsReturned;
//private Integer totalMealsRefunded;

    // CONSTRUCTOR

    public Customer() {
    }

    // GETTERS AND SETTERS


}
