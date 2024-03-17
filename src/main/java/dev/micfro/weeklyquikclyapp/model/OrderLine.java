package dev.micfro.weeklyquikclyapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;

    private Long productId;

    @OneToMany
    private List<Item> itemList;

    private Double discount;
}
