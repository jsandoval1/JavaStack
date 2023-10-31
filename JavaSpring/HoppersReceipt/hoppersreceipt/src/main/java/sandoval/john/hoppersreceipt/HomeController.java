package sandoval.john.hoppersreceipt;

// Import required libraries and classes
import org.springframework.stereotype.Controller; // Import Spring's Controller annotation
import org.springframework.web.bind.annotation.GetMapping; // Import Spring's GetMapping annotation

import java.util.ArrayList; // Import the ArrayList class
import java.util.Arrays; // Import the Arrays class
import sandoval.john.hoppersreceipt.models.Item; // Import the custom Item class

import org.springframework.ui.Model; // Import Spring's Model class

// Define a controller class
@Controller
public class HomeController {

    // Create an ArrayList to store a list of items.
    ArrayList<Item> items = new ArrayList<>();

    {
        // Populate the ArrayList with sample items.
        items.addAll(Arrays.asList(
                new Item("Grace Hopper", "Copper Wire", 5.25, "11.8 inch copper wire", "Home Depot"), // Instance of the Item class.
                new Item("John Sandoval", "Tiny brown Wire", 90.25, "wire", "Target") // Instance of the Item class.
        ));
    }

    @GetMapping("/") // Handles HTTP GET requests to the root URL ("/")
    public String index(Model model) {

        // Add the list of items to the model, making it available to the view.
        model.addAttribute("items", items);

        // Return the name of the view template ("index").
        return "index";
    }
}
