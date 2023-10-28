package sandoval.john.daikichipathvariables;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {

    @RequestMapping("/travel/{country}")
    public String daikichi(@PathVariable("country") String country) {
        return "Congratulations. You will soon travel to " + country + "!";
    }

    @RequestMapping("/lotto/{integer}")
    public String lotto(@PathVariable("integer") Integer integer) {
        if (integer %2 == 0){
            return "You will take a grand journey in the near future, but be weary of tempting offers";
        } else {
            return "You have enjoyed rhe fruits of your labor but now is a great time to spend time with family and friends.";
        }
    }
}
