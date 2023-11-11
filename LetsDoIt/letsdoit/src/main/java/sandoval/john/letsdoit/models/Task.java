package sandoval.john.letsdoit.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tasks")
public class Task {

    // ? Field Attributes and Back end Validations
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // {
    //     "taskName": "Finish project",
    //     "taskDescription": "Complete the coding project for the client",
    //     "priority": "HIGH",
    //     "dueDate": "2022-12-31"
    // }

    @NotBlank(message = "Task name is required!")
    @Size(min = 2, message = "Task name must be at least 2 characters long")
    private String taskName;

    @NotBlank(message = "Task description is required!")
    @Size(min = 2, message = "Task description must be at least 2 characters long")
    @Size(max = 1000, message = "Task description must be less than 1000 characters long")
    private String taskDescription;

    // * Priority Status
    // ! Need to test if this worked
    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    @NotNull(message = "Task priority is required!")
    @Enumerated(EnumType.STRING)
    private Priority priority;

    // * Completion Status
    // ! Need to test if this worked
    public enum CompletionStatus {
        STARTED, IN_PROGRESS, DONE
    }

    @NotNull(message = "Task completion status is required!")
    @Enumerated(EnumType.STRING)
    private CompletionStatus completionStatus = CompletionStatus.STARTED;

    // * Due Date
    @NotNull(message = "Task due date is required!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    // * Image file
    // private byte[] imageFile; //! Retire idea of trying to get images for tasks
    // to work

    // * Mapping many tasks to one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // * For created and updated at
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    // ? Empty Constructor
    public Task() {
    }

    // ? Getters and Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public CompletionStatus getCompletionStatus() {
        return this.completionStatus;
    }

    public void setCompletionStatus(CompletionStatus completionStatus) {
        this.completionStatus = completionStatus;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
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
