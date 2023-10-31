package sandoval.john.displaydate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sandoval.john.displaydate.models.DateTimeModel;

import java.text.SimpleDateFormat;
import java.util.Date;

// Define a controller class for handling date and time display
@Controller
public class DateTimeController {

    // Define a route for the dashboard
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // Return the "dashboard" template
    }

    // Define a route for displaying the current date
    @GetMapping("/date")
    public String currentDate(Model model) { //! Method: currentDate
        Date currentDate = new Date();// Get the current date
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");// Format the date in the desired format
        String formattedDate = dateFormat.format(currentDate);
        DateTimeModel dateTimeModel = new DateTimeModel(formattedDate, null); // Create a DateTimeModel object with the formatted date and no time
        model.addAttribute("dateTimeModel", dateTimeModel); // Add the dateTimeModel to the model for rendering in the view
        return "date"; // Return the "date" template
    }

    // Define a route for displaying the current time
    @GetMapping("/time")
    public String currentTime(Model model) {
        Date currentTime = new Date();// Get the current time
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");// Format the time in the desired format
        String formattedTime = timeFormat.format(currentTime);
        DateTimeModel dateTimeModel = new DateTimeModel(null, formattedTime);// Create a DateTimeModel object with the formatted time and no date
        model.addAttribute("dateTimeModel", dateTimeModel);// Add the dateTimeModel to the model for rendering in the view
        return "time"; // Return the "time" template
    }
}
