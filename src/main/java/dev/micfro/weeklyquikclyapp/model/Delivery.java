package dev.micfro.weeklyquikclyapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderDeliveryCustomerId;

    private Long orderDeliveryDriverId;

    private Long orderDeliveryVehicleId;

    private Long orderDeliveryRouteId;


    private Date orderDeliveryStartDate;

    private Date orderDeliveryEndDate;

    private String orderDeliveryStatus;  //ENUM

    private boolean orderDeliveryIsCompleted;




    private Integer orderDeliveryDistance;




    private String orderDeliveryTrackingNumber;

    private String orderDeliveryTrackingUrl;


}
