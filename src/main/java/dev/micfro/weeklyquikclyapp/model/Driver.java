package dev.micfro.weeklyquikclyapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long EmployeeId;

    private String driverLicenseNumber;

    private String driverLicenseExpirationDate;

}
