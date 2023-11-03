package sandoval.john.burgertrackertwo.models;
// !Responsible for the book entity, data structure
// ? Future John, if you have questions view AllBooks assignment
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "burgers")
public class Burger {

    // * Defining the fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 4, max = 100, message = "Burger name must be between 4 and 100 characters")
    private String burgerName;

    @NotNull
    @Size(min = 4, max = 100, message = "Restaurant name must be between 4 and 100 characters")
    private String restaurantName;

    @NotNull
    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")    
    private int rating;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    // * Empty Constructor
    public Burger() {
    }

    // * Constructor with all NEEDED fields passed in as parameters, id, created at, and updated at are not required
    public Burger(String burgerName, String restaurantName, int rating) {
        this.burgerName = burgerName;
        this.restaurantName = restaurantName;
        this.rating = rating;
    }

    // * Getters and Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBurgerName() {
        return this.burgerName;
    }

    public void setBurgerName(String burgerName) {
        this.burgerName = burgerName;
    }

    public String getRestaurantName() {
        return this.restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    // * toString method
    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", burgerName='" + getBurgerName() + "'" +
                ", restaurantName='" + getRestaurantName() + "'" +
                ", rating='" + getRating() + "'" +
                ", createdAt='" + getCreatedAt() + "'" +
                ", updatedAt='" + getUpdatedAt() + "'" +
                "}";
    }

    //* PrePersist and PreUpdate methods to set the createdAt and updatedAt fields
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

}