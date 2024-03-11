package dev.micfro.weeklyquikclyapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleType;  //ENUM

    private Double loadCapacitySize;

    private Double loadCapacityWeight;

    private Double pricePerMeter;

    private String vehicleMake;

    private String vehicleModel;

    private String vehicleYear;

    private String vehicleLicensePlate;

    private String maintenanceStatus;  //ENUM

    private String vehicleImageUrl;

    private Date vehiclePurchaseDate;

    private Date expectedLifeTime;

    private String vehiclePurchasePrice;

    private Long metersDriven;

    private String vehicleInsurancePolicyNumber;

    private String vehicleInsuranceExpirationDate;


}
