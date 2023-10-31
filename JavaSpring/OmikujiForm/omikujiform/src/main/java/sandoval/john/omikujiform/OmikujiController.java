package sandoval.john.omikujiform;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping; // Import the Spring GetMapping annotation for handling GET requests
import org.springframework.web.bind.annotation.PostMapping; // Import the Spring PostMapping annotation for handling POST requests
import org.springframework.web.bind.annotation.RequestParam; // Import the Spring RequestParam annotation for retrieving request parameters
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession; // Import the HttpSession class for managing sessions in a web application

@Controller
public class OmikujiController {

    // Redirect to the /omikuji page when user loads in 
    @GetMapping("/")
    public String renderHome(){
        return "redirect:/omikuji";
    }

    // Display the Omikuji form
    @GetMapping("/omikuji")
    public String showOmikujiForm(Model model) {
        return "omikuji-form";
    }
    
    //When the user clicks the submit button on the Omikuji form, this method is called
    @PostMapping("/omikuji/submit")
    public String processOmikujiForm(
        @RequestParam("number") int number, //RequestParam is used to retrieve the data from the HTTP request
        @RequestParam("city") String city,
        @RequestParam("person") String person,
        @RequestParam("endeavor") String endeavor,
        @RequestParam("livingThing") String livingThing,
        @RequestParam("niceWords") String niceWords,
        HttpSession session
    ) {
        // Save the user's answers in a session
        session.setAttribute("number", number); // setAttribute is used to store the data in the session
        session.setAttribute("city", city);
        session.setAttribute("person", person);
        session.setAttribute("endeavor", endeavor);
        session.setAttribute("livingThing", livingThing);
        session.setAttribute("niceWords", niceWords);
        
        // Log the submission
        System.out.println("Submitted Omikuji form with answers.");
        
        // Redirect to the show page
        return "redirect:/omikuji/show";
    }
    
    @GetMapping("/omikuji/show")
    public String showFortune(HttpSession session, Model model) {
        // Retrieve the user's answers from the session
        int number = (int) session.getAttribute("number"); // getAttribute is used to retrieve the data from the session
        String city = (String) session.getAttribute("city");
        String person = (String) session.getAttribute("person");
        String endeavor = (String) session.getAttribute("endeavor");
        String livingThing = (String) session.getAttribute("livingThing");
        String niceWords = (String) session.getAttribute("niceWords");
        
        // Log the retrieval
        System.out.println("Retrieved inputs.");
        
        // Pass the answers to the JSP template
        model.addAttribute("number", number); // addAttribute is used to store the data in the model
        model.addAttribute("city", city);
        model.addAttribute("person", person);
        model.addAttribute("endeavor", endeavor);
        model.addAttribute("livingThing", livingThing);
        model.addAttribute("niceWords", niceWords);
        
        // Display the answers in the omikuji-show template
        return "omikuji-show";
    }
}
