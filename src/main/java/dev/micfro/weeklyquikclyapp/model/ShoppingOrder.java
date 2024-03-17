package dev.micfro.weeklyquikclyapp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class ShoppingOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @ManyToMany
    private List<ShoppingOrderLine> shoppingOrderLines;

    @OneToMany
    private List<OrderLine> orderLines;

    @ManyToMany
    private List<Meal> meals;


    @Enumerated(EnumType.STRING)
    private ShoppingOrderStatus shoppingOrderStatus;


    private LocalDateTime placedDateTime;
    private LocalDateTime packedDateTime;
    private LocalDateTime shippedDateTime;
    private LocalDateTime deliveredDateTime;
    private LocalDateTime cancelledDateTime;

    // PAYMENT
//    private Long PaymentId;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private BigDecimal paymentAmount;

    private LocalDateTime paymentDateTime;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;


    // Constructor
    public ShoppingOrder() {
    }

    // toString

    // Getters and Setters

}
