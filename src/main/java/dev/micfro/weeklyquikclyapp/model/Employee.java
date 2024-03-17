package dev.micfro.weeklyquikclyapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
public class Employee extends User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




    // Image URL
    private String imageUrl;

    // Additional Information
    private String additionalInformation;


    // DATE FIELDS

    // Date Created
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "Date Created must be in the past")
    private LocalDateTime dateCreated = LocalDateTime.now();

    // Date Updated
    private LocalDateTime dateUpdated;

    // Date Deleted
    private LocalDateTime dateDeleted;

    // Date Last Login
    private LocalDateTime dateLastLogin;

    // Date Last Logout
    private LocalDateTime dateLastLogout;




  // EMPLOYEE DETAILS

    private String jobTitle;

    private String jobLocation;

    private String dateOfJoining;

    private boolean isPermanent;

    private BigDecimal salary;


    @Enumerated(EnumType.STRING)
    private EmployeeRole role;



    private String department;


    // Constructors

    public Employee() {
    }

    // toString

    // Getters and Setters


}

enum EmployeeRole {
    MANAGER, SALES, MARKETING, IT, HR
}