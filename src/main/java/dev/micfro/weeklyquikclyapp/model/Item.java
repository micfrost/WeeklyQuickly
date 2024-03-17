package dev.micfro.weeklyquikclyapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    @DecimalMin(value = "0.0", inclusive = false, message = "Producer price must be greater than 0")
    private BigDecimal priceProducer;

    private Long quantity = 1L;

    private LocalDate expiryDate;

    private Integer amountOfDaysToExpireToSetDiscount;

    private boolean isToBeDiscounted;

    private boolean isValid;

    private boolean isExpired;     // Hide items after expiration date
    // Hide items from the list of items in the inventory

    private boolean isSold;

    private boolean isReturned;

    private Long addedByEmployeeID;

    private LocalDateTime addedByDateTime;

    private Long lastModifiedByEmployeeID;

    private LocalDateTime lastModifiedByDateTime;

    // methods
    public boolean isToBeDiscounted() {
        return LocalDate.now().isBefore(expiryDate.minusDays(amountOfDaysToExpireToSetDiscount));
    }

    public BigDecimal getPriceDiscounted() {
        return priceProducer.multiply(BigDecimal.valueOf(1 - product.getDiscount().doubleValue()));
    }


    public boolean isValid() {
        return LocalDate.now().isBefore(expiryDate);
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @PostLoad
    @PostUpdate
    public void updateStatus() {
        LocalDate now = LocalDate.now();
        isValid = now.isBefore(expiryDate);
        isExpired = now.isAfter(expiryDate);
    }


    // Constructors
    public Item() {
    }

    public Item(Long id, Product product, BigDecimal priceProducer, Long quantity, LocalDate expiryDate, Integer amountOfDaysToExpireToSetDiscount, boolean isToBeDiscounted, boolean isValid, boolean isExpired, boolean isSold, boolean isReturned, Long addedByEmployeeID, LocalDateTime addedByDateTime, Long lastModifiedByEmployeeID, LocalDateTime lastModifiedByDateTime) {
        this.id = id;
        this.product = product;
        this.priceProducer = priceProducer;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.amountOfDaysToExpireToSetDiscount = amountOfDaysToExpireToSetDiscount;
        this.isToBeDiscounted = isToBeDiscounted;
        this.isValid = isValid;
        this.isExpired = isExpired;
        this.isSold = isSold;
        this.isReturned = isReturned;
        this.addedByEmployeeID = addedByEmployeeID;
        this.addedByDateTime = addedByDateTime;
        this.lastModifiedByEmployeeID = lastModifiedByEmployeeID;
        this.lastModifiedByDateTime = lastModifiedByDateTime;
    }

    // to string

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", product=" + product +
                ", priceProducer=" + priceProducer +
                ", quantity=" + quantity +
                ", expiryDate=" + expiryDate +
                ", amountOfDaysToExpireToSetDiscount=" + amountOfDaysToExpireToSetDiscount +
                ", isToBeDiscounted=" + isToBeDiscounted +
                ", isValid=" + isValid +
                ", isExpired=" + isExpired +
                ", isSold=" + isSold +
                ", isReturned=" + isReturned +
                ", addedByEmployeeID=" + addedByEmployeeID +
                ", addedByDateTime=" + addedByDateTime +
                ", lastModifiedByEmployeeID=" + lastModifiedByEmployeeID +
                ", lastModifiedByDateTime=" + lastModifiedByDateTime +
                '}';
    }


    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getPriceProducer() {
        return priceProducer;
    }

    public void setPriceProducer(BigDecimal priceProducer) {
        this.priceProducer = priceProducer;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getAmountOfDaysToExpireToSetDiscount() {
        return amountOfDaysToExpireToSetDiscount;
    }

    public void setAmountOfDaysToExpireToSetDiscount(Integer amountOfDaysToExpireToSetDiscount) {
        this.amountOfDaysToExpireToSetDiscount = amountOfDaysToExpireToSetDiscount;
    }

    public void setToBeDiscounted(boolean toBeDiscounted) {
        isToBeDiscounted = toBeDiscounted;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

    public Long getAddedByEmployeeID() {
        return addedByEmployeeID;
    }

    public void setAddedByEmployeeID(Long addedByEmployeeID) {
        this.addedByEmployeeID = addedByEmployeeID;
    }

    public LocalDateTime getAddedByDateTime() {
        return addedByDateTime;
    }

    public void setAddedByDateTime(LocalDateTime addedByDateTime) {
        this.addedByDateTime = addedByDateTime;
    }

    public Long getLastModifiedByEmployeeID() {
        return lastModifiedByEmployeeID;
    }

    public void setLastModifiedByEmployeeID(Long lastModifiedByEmployeeID) {
        this.lastModifiedByEmployeeID = lastModifiedByEmployeeID;
    }

    public LocalDateTime getLastModifiedByDateTime() {
        return lastModifiedByDateTime;
    }

    public void setLastModifiedByDateTime(LocalDateTime lastModifiedByDateTime) {
        this.lastModifiedByDateTime = lastModifiedByDateTime;
    }
}
