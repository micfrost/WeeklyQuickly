package dev.micfro.weeklyquikclyapp.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class ShoppingOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_meal",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id")
    )
    private List<Meal> meals;


    private String orderStatus;  //ENUM: OPEN, COMPLETED, CANCELLED

    @Temporal(TemporalType.TIMESTAMP)
    Date orderStartDate;

    @Temporal(TemporalType.TIMESTAMP)
    Date orderEndDate;


    private String orderDeliveryTime;
    private String orderDeliveryDay;
    private String orderDeliveryFrequency; //ENUM





    private String orderPaymentMethod;  //ENUM
    private String orderPaymentStatus;  //ENUM
    private String orderPaymentDate;
    private String orderPaymentTime;
    private String orderPaymentConfirmationNumber;
    private String orderPaymentTransactionId;
    private String orderPaymentAmount;
    private String orderPaymentMethodType;  //ENUM



// Constructor
    public ShoppingOrder() {
    }


}
