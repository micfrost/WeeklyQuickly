package dev.micfro.weeklyquikclyapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // First name
//    @NotNull(message = "First name is required")
//    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name must contain only letters")
//    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    // Last name
//    @NotNull(message = "Last name is required")
//    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name must contain only letters")
//    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    // Email
//    @NotNull(message = "Email Address is required")
//    @NotBlank(message = "Email Address is required")
//    @Email(message = "Invalid email format")
    private String email;

    // Email Verification
    private boolean isEmailVerified;

    // Password
//    @NotNull(message = "Password is required")
//    @Size(min = 8, max = 50, message = "Password must be between 8 and 50 characters")
//    @Pattern(
//            regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!]).*$",
//            message = "Password must contain at least one letter, one number, and one special character"
//    )
    private String password;

    // Phone Number
//    @NotBlank(message = "Phone Number is required")
//    @Size(min = 6, max = 14, message = "Phone Number must be between 6 and 14 digits")
//    @Pattern(regexp = "\\d{6,14}", message = "Phone Number must be between 6 and 14 digits")
    private String phoneNumber;

    // Date of Birth
//    @NotNull(message = "Date of Birth is required")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    @Past(message = "Date of Birth should be in the past")
    private LocalDate dateOfBirth;


    // Address
//    @NotNull(message = "Country is required")
//    @Size(min = 2, max = 50, message = "Country must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Country must contain only letters and spaces")
    private String country = "Germany";

//    @NotNull(message = "City is required")
//    @Size(min = 2, max = 50, message = "City must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "City must contain only letters and spaces")
    private String city;

//    @NotNull(message = "Postal Code is required")
//    @Pattern(regexp = "\\d{5}", message = "Postal Code must be 5 digits")
    private String postalCode;

//    @NotNull(message = "Street is required")
//    @Size(min = 2, max = 50, message = "Street must be between 2 and 50 characters")
//    @Pattern(regexp = "^[a-zA-Z .ß]+$", message = "Street must contain only letters, spaces, '.', and 'ß'")
    private String Street;

//    @NotNull(message = "House Number is required")
//    @Min(value = 1, message = "House Number must be at least 1")
    private Integer houseNumber;


    // Constructors
    public User() {
    }


    // ToString

    // Getters, and setters



}
