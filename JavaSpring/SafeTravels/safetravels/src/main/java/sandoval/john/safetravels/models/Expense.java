package sandoval.john.safetravels.models;

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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "expenses")
public class Expense {

    // * Method attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Size(min = 4, max = 100, message = "Expense name must be between 4 and 100 characters long")
    private String expenseName;

    @NotEmpty
    @Size(min = 4, max = 100, message = "Expense vendor must be between 4 and 100 characters long")
    private String expenseVendor;

    @Min(value = 1, message = "Expense amount must be at least $1.00") //* To validate a ddouble, use @Min and @Max, @NotEmpty is for strings or lists
    @Max(value = 500, message = "Expense amount must not exceed $500.00")
    private double expenseAmount;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    // * Constructor
    public Expense() {
    }

    // * Constructor with all parameters
    public Expense(String expenseName, String expenseVendor, double expenseAmount) {
        this.expenseName = expenseName;
        this.expenseVendor = expenseVendor;
        this.expenseAmount = expenseAmount;
    }

    // * Getters and Setters
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExpenseName() {
        return this.expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public String getExpenseVendor() {
        return this.expenseVendor;
    }

    public void setExpenseVendor(String expenseVendor) {
        this.expenseVendor = expenseVendor;
    }

    public double getExpenseAmount() {
        return this.expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
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
                ", expenseName='" + getExpenseName() + "'" +
                ", expenseVendor='" + getExpenseVendor() + "'" +
                ", expenseAmount='" + getExpenseAmount() + "'" +
                ", createdAt='" + getCreatedAt() + "'" +
                ", updatedAt='" + getUpdatedAt() + "'" +
                "}";
    }

    // * PrePersist and PreUpdate methods to set the createdAt and updatedAt fields
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

}
