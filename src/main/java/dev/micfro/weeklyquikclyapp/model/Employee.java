package dev.micfro.weeklyquikclyapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // USER DETAILS

    // First name
    @NotNull(message = "First name is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name must contain only letters")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    // Last name
    @NotNull(message = "Last name is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name must contain only letters")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    // Email
    @NotNull(message = "Email Address is required")
    @NotBlank(message = "Email Address is required")
    @Email(message = "Invalid email format")
    private String email;

    // Email Verification
    private boolean isEmailVerified;

    // Password
    @NotNull(message = "Password is required")
    @Size(min = 8, max = 50, message = "Password must be between 8 and 50 characters")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!]).*$",
            message = "Password must contain at least one letter, one number, and one special character"
    )
    private String password;

    // ADDRESS DETAILS

    @NotNull(message = "Country is required")
    @Size(min = 2, max = 50, message = "Country must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Country must contain only letters and spaces")
    private String country = "Germany";

    @NotNull(message = "City is required")
    @Size(min = 2, max = 50, message = "City must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "City must contain only letters and spaces")
    private String city;

    @NotNull(message = "Postal Code is required")
    @Pattern(regexp = "\\d{5}", message = "Postal Code must be 5 digits")
    private String postalCode;

    @NotNull(message = "Street is required")
    @Size(min = 2, max = 50, message = "Street must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z .ß]+$", message = "Street must contain only letters, spaces, '.', and 'ß'")
    private String Street;

    @NotNull(message = "House Number is required")
    @Min(value = 1, message = "House Number must be at least 1")
    private Integer houseNumber;


    // Phone Number
    @NotBlank(message = "Phone Number is required")
    @Size(min = 6, max = 14, message = "Phone Number must be between 6 and 14 digits")
    @Pattern(regexp = "\\d{6,14}", message = "Phone Number must be between 6 and 14 digits")
    private String phoneNumber;

    // Date of Birth
    @NotNull(message = "Date of Birth is required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "Date of Birth should be in the past")
    private LocalDate dateOfBirth;

    // Image URL
    private String imageUrl;

    // Additional Information
    private String additionalInformation;


    // DATE FIELDS

    // Date Created
    @NotNull(message = "Date Created is required")
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
    @NotNull(message = "Job title is required")
    private String jobTitle;

    private String jobLocation;

    private String dateOfJoining;

    private boolean isPermanent;

    private double salary;

    @NotNull(message = "Employee role is required")
    private String employeeRole;


    @NotNull(message = "Department is required")
    private String department;


    // CONSTRUCTOR

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email, boolean isEmailVerified, String password, String country, String city, String postalCode, String street, Integer houseNumber, String phoneNumber, LocalDate dateOfBirth, String imageUrl, String additionalInformation, String jobTitle, String jobLocation, String dateOfJoining, boolean isPermanent, double salary, String employeeRole, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isEmailVerified = isEmailVerified;
        this.password = password;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        Street = street;
        this.houseNumber = houseNumber;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.imageUrl = imageUrl;
        this.additionalInformation = additionalInformation;
        this.jobTitle = jobTitle;
        this.jobLocation = jobLocation;
        this.dateOfJoining = dateOfJoining;
        this.isPermanent = isPermanent;
        this.salary = salary;
        this.employeeRole = employeeRole;
        this.department = department;
    }

// GETTERS AND SETTERS


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public LocalDateTime getDateDeleted() {
        return dateDeleted;
    }

    public void setDateDeleted(LocalDateTime dateDeleted) {
        this.dateDeleted = dateDeleted;
    }

    public LocalDateTime getDateLastLogin() {
        return dateLastLogin;
    }

    public void setDateLastLogin(LocalDateTime dateLastLogin) {
        this.dateLastLogin = dateLastLogin;
    }

    public LocalDateTime getDateLastLogout() {
        return dateLastLogout;
    }

    public void setDateLastLogout(LocalDateTime dateLastLogout) {
        this.dateLastLogout = dateLastLogout;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public boolean isPermanent() {
        return isPermanent;
    }

    public void setPermanent(boolean permanent) {
        isPermanent = permanent;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

