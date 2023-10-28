package sandoval.john.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam; //! 
import org.springframework.web.bind.annotation.RestController; //! 

@RestController //! Needs to be annotated with @RestController because it will be used as a controller.
public class HomeController {
    @RequestMapping("/") //! This is the URL that will be called when the user hits the home page.
    public String hello(
            @RequestParam(value="name", required=false) String name, 
            @RequestParam(value="last_name", required=false) String last_name,
            @RequestParam(value="times", required=false) Integer times) {
        // Initialize an empty string to store the output
        String output = "";

        // If 'times' is provided and greater than 0
        if (times != null && times > 0) {
            // Loop 'times' number of times
            for (int i = 0; i < times; i++) {
                // If 'name' is provided, append "Hello " + name + " " to the output
                if (name != null) {
                    output += "Hello " + name + " ";
                }
                // If 'last_name' is provided, append "Hello " + last_name + " " to the output
                else if (last_name != null) {
                    output += "Hello " + last_name + " ";
                }
                // If neither 'name' nor 'last_name' is provided, append "Hello Human " to the output
                else {
                    output += "Hello Human ";
                }
            }
        } else {  // 'times' is not provided or is 0 or negative, does not initiate the first half
            // If 'name' is provided, append "Hello " + name + " " to the output
            if (name != null) {
                output += "Hello " + name + " ";
            }
            // If 'last_name' is provided, append "Hello " + last_name + " " to the output
            if (last_name != null) {
                output += "Hello " + last_name + " ";
            }
            // If the output is still empty, set it to "Hello Human"
            if (output.isEmpty()) {
                output = "Hello Human";
            }
        }

        // Return the accumulated output
        return output;
    }
}
