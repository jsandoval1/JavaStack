package sandoval.john.displaydate.models;

public class DateTimeModel {
    // Fields to store formatted date and time
    private String formattedDate;
    private String formattedTime;


    // Constructor to initialize the model with no formatted date and time
    public DateTimeModel() {
    }

    // Constructor to initialize the model with formatted date and time
    public DateTimeModel(String formattedDate, String formattedTime) {
        // Set the formatted date using the provided value
        this.formattedDate = formattedDate;
        // Set the formatted time using the provided value
        this.formattedTime = formattedTime;
    }

    // Getter method to retrieve the formatted date
    public String getFormattedDate() {
        // Return the formatted date to the caller
        return formattedDate;
    }

    // Getter method to retrieve the formatted time
    public String getFormattedTime() {
        // Return the formatted time to the caller
        return formattedTime;
    }
}
