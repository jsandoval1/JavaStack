package sandoval.john.booksapi.models;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity // Represents an entity model for our application
@Table(name="books") // Sets this as a table in the database
public class Book {
    @Id // This will be the primary key for our table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Sets this as an auto-incrementing value
    private Long id;
    @NotNull
    @Size(min = 5, max = 200) // Sets this as a size constraint
    private String title;
    @NotNull
    @Size(min = 5, max = 200)
    private String description;
    @NotNull
    @Size(min = 3, max = 40)
    private String language;
    @NotNull
    @Min(100) // Sets this as a min constraint
    private Integer numberOfPages;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Book() {
    }
    public Book(String title, String desc, String lang, int pages) {
        this.title = title;
        this.description = desc;
        this.language = lang;
        this.numberOfPages = pages;
    }
    
    // other getters and setters removed for brevity
    @PrePersist // This method will be called before the entity is saved to the database
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate // This method will be called before the entity is updated to the database
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
