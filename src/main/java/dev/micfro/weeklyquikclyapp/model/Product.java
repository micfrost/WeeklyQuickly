package dev.micfro.weeklyquikclyapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne()
    private Category category;

//    @Size(max = 100, message = "Description should not exceed 100 characters")
    private String description;

//    @URL(message = "Invalid image URL format")
    private String imageUrl;

    @OneToMany(mappedBy = "product")
    private List<Item> quantityInInventory; // Sum of all quantities of items in stock and valid and expired

    private Long quantityValid; // Sum of all quantities of valid items, not expired
    private Long quantityExpired;
    private Long quantitySold;
//    private Long quantityReturned;

    private Long quantityLevelToRestock;
    private Long quantityLevelToOffer;

    private BigDecimal priceProducerAverage;
    private BigDecimal priceProducerLowest;
    private BigDecimal priceProducerHighest;

    private BigDecimal profitMargin;
    private BigDecimal priceMinMargin;
    private BigDecimal priceOptimalMargin;
    private BigDecimal priceRetail;
    private BigDecimal Discount;
    private BigDecimal priceDiscounted;


    private BigDecimal weight;
    private BigDecimal volume;

    private BigDecimal spaceRequiredOneItem;

    private BigDecimal spaceOccupiedAllItemsInInventory;

    private BigDecimal spaceOccupiedAllItemsValid;

    private BigDecimal spaceOccupiedAllItemsExpired;


    private Long addedByEmployeeID;

    private LocalDateTime addedByDateTime;

    private Long lastModifiedByEmployeeID;

    private LocalDateTime lastModifiedByDateTime;

    // methods

    public void addQuantityInInventory(Item item) {
        quantityInInventory.add(item);
        item.setProduct(this);
    }

    public void removeQuantityInInventory(Item item) {
        quantityInInventory.remove(item);
        item.setProduct(null);
    }

    public void addQuantityValid(Long quantity) {
        this.quantityValid += quantity;
    }

    public void addQuantityExpired(Long quantity) {
        this.quantityExpired += quantity;
    }

    public void addQuantitySold(Long quantity) {
        this.quantitySold += quantity;
    }

    public void addQuantityLevelToRestock(Long quantity) {
        this.quantityLevelToRestock += quantity;
    }






    // CONSTRUCTOR
    public Product() {
    }

//    name, category_id, description, imageUrl
    public Product(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }


    public Product(Long id, String name, Category category, String description, String imageUrl, List<Item> quantityInInventory, Long quantityValid, Long quantityExpired, Long quantitySold, Long quantityLevelToRestock, Long quantityLevelToOffer, BigDecimal priceProducerAverage, BigDecimal priceProducerLowest, BigDecimal priceProducerHighest, BigDecimal profitMargin, BigDecimal priceMinMargin, BigDecimal priceOptimalMargin, BigDecimal priceRetail, BigDecimal discount, BigDecimal priceDiscounted, BigDecimal weight, BigDecimal volume, BigDecimal spaceRequiredOneItem, BigDecimal spaceOccupiedAllItemsInInventory, BigDecimal spaceOccupiedAllItemsValid, BigDecimal spaceOccupiedAllItemsExpired, Long addedByEmployeeID, LocalDateTime addedByDateTime, Long lastModifiedByEmployeeID, LocalDateTime lastModifiedByDateTime) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.imageUrl = imageUrl;
        this.quantityInInventory = quantityInInventory;
        this.quantityValid = quantityValid;
        this.quantityExpired = quantityExpired;
        this.quantitySold = quantitySold;
        this.quantityLevelToRestock = quantityLevelToRestock;
        this.quantityLevelToOffer = quantityLevelToOffer;
        this.priceProducerAverage = priceProducerAverage;
        this.priceProducerLowest = priceProducerLowest;
        this.priceProducerHighest = priceProducerHighest;
        this.profitMargin = profitMargin;
        this.priceMinMargin = priceMinMargin;
        this.priceOptimalMargin = priceOptimalMargin;
        this.priceRetail = priceRetail;
        Discount = discount;
        this.priceDiscounted = priceDiscounted;
        this.weight = weight;
        this.volume = volume;
        this.spaceRequiredOneItem = spaceRequiredOneItem;
        this.spaceOccupiedAllItemsInInventory = spaceOccupiedAllItemsInInventory;
        this.spaceOccupiedAllItemsValid = spaceOccupiedAllItemsValid;
        this.spaceOccupiedAllItemsExpired = spaceOccupiedAllItemsExpired;
        this.addedByEmployeeID = addedByEmployeeID;
        this.addedByDateTime = addedByDateTime;
        this.lastModifiedByEmployeeID = lastModifiedByEmployeeID;
        this.lastModifiedByDateTime = lastModifiedByDateTime;
    }
// TO STRING

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", quantityInInventory=" + quantityInInventory +
                ", quantityValid=" + quantityValid +
                ", quantityExpired=" + quantityExpired +
                ", quantitySold=" + quantitySold +
                ", quantityLevelToRestock=" + quantityLevelToRestock +
                ", quantityLevelToOffer=" + quantityLevelToOffer +
                ", priceProducerAverage=" + priceProducerAverage +
                ", priceProducerLowest=" + priceProducerLowest +
                ", priceProducerHighest=" + priceProducerHighest +
                ", profitMargin=" + profitMargin +
                ", priceMinMargin=" + priceMinMargin +
                ", priceOptimalMargin=" + priceOptimalMargin +
                ", priceRetail=" + priceRetail +
                ", Discount=" + Discount +
                ", priceDiscounted=" + priceDiscounted +
                ", weight=" + weight +
                ", volume=" + volume +
                ", spaceRequiredOneItem=" + spaceRequiredOneItem +
                ", spaceOccupiedAllItemsInInventory=" + spaceOccupiedAllItemsInInventory +
                ", spaceOccupiedAllItemsValid=" + spaceOccupiedAllItemsValid +
                ", spaceOccupiedAllItemsExpired=" + spaceOccupiedAllItemsExpired +
                ", addedByEmployeeID=" + addedByEmployeeID +
                ", addedByDateTime=" + addedByDateTime +
                ", lastModifiedByEmployeeID=" + lastModifiedByEmployeeID +
                ", lastModifiedByDateTime=" + lastModifiedByDateTime +
                '}';
    }


    // GETTERS AND SETTERS


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Item> getQuantityInInventory() {
        return quantityInInventory;
    }

    public void setQuantityInInventory(List<Item> quantityInInventory) {
        this.quantityInInventory = quantityInInventory;
    }

    public Long getQuantityValid() {
        return quantityValid;
    }

    public void setQuantityValid(Long quantityValid) {
        this.quantityValid = quantityValid;
    }

    public Long getQuantityExpired() {
        return quantityExpired;
    }

    public void setQuantityExpired(Long quantityExpired) {
        this.quantityExpired = quantityExpired;
    }

    public Long getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(Long quantitySold) {
        this.quantitySold = quantitySold;
    }

    public Long getQuantityLevelToRestock() {
        return quantityLevelToRestock;
    }

    public void setQuantityLevelToRestock(Long quantityLevelToRestock) {
        this.quantityLevelToRestock = quantityLevelToRestock;
    }

    public Long getQuantityLevelToOffer() {
        return quantityLevelToOffer;
    }

    public void setQuantityLevelToOffer(Long quantityLevelToOffer) {
        this.quantityLevelToOffer = quantityLevelToOffer;
    }

    public BigDecimal getPriceProducerAverage() {
        return priceProducerAverage;
    }

    public void setPriceProducerAverage(BigDecimal priceProducerAverage) {
        this.priceProducerAverage = priceProducerAverage;
    }

    public BigDecimal getPriceProducerLowest() {
        return priceProducerLowest;
    }

    public void setPriceProducerLowest(BigDecimal priceProducerLowest) {
        this.priceProducerLowest = priceProducerLowest;
    }

    public BigDecimal getPriceProducerHighest() {
        return priceProducerHighest;
    }

    public void setPriceProducerHighest(BigDecimal priceProducerHighest) {
        this.priceProducerHighest = priceProducerHighest;
    }

    public BigDecimal getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(BigDecimal profitMargin) {
        this.profitMargin = profitMargin;
    }

    public BigDecimal getPriceMinMargin() {
        return priceMinMargin;
    }

    public void setPriceMinMargin(BigDecimal priceMinMargin) {
        this.priceMinMargin = priceMinMargin;
    }

    public BigDecimal getPriceOptimalMargin() {
        return priceOptimalMargin;
    }

    public void setPriceOptimalMargin(BigDecimal priceOptimalMargin) {
        this.priceOptimalMargin = priceOptimalMargin;
    }

    public BigDecimal getPriceRetail() {
        return priceRetail;
    }

    public void setPriceRetail(BigDecimal priceRetail) {
        this.priceRetail = priceRetail;
    }

    public BigDecimal getDiscount() {
        return Discount;
    }

    public void setDiscount(BigDecimal discount) {
        Discount = discount;
    }

    public BigDecimal getPriceDiscounted() {
        return priceDiscounted;
    }

    public void setPriceDiscounted(BigDecimal priceDiscounted) {
        this.priceDiscounted = priceDiscounted;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getSpaceRequiredOneItem() {
        return spaceRequiredOneItem;
    }

    public void setSpaceRequiredOneItem(BigDecimal spaceRequiredOneItem) {
        this.spaceRequiredOneItem = spaceRequiredOneItem;
    }

    public BigDecimal getSpaceOccupiedAllItemsInInventory() {
        return spaceOccupiedAllItemsInInventory;
    }

    public void setSpaceOccupiedAllItemsInInventory(BigDecimal spaceOccupiedAllItemsInInventory) {
        this.spaceOccupiedAllItemsInInventory = spaceOccupiedAllItemsInInventory;
    }

    public BigDecimal getSpaceOccupiedAllItemsValid() {
        return spaceOccupiedAllItemsValid;
    }

    public void setSpaceOccupiedAllItemsValid(BigDecimal spaceOccupiedAllItemsValid) {
        this.spaceOccupiedAllItemsValid = spaceOccupiedAllItemsValid;
    }

    public BigDecimal getSpaceOccupiedAllItemsExpired() {
        return spaceOccupiedAllItemsExpired;
    }

    public void setSpaceOccupiedAllItemsExpired(BigDecimal spaceOccupiedAllItemsExpired) {
        this.spaceOccupiedAllItemsExpired = spaceOccupiedAllItemsExpired;
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
