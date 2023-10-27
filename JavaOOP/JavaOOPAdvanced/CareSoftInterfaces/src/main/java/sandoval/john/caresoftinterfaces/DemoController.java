package sandoval.john.caresoftinterfaces;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @RequestMapping("/")
    public String index(){
        return "I hope this works!!";
    }
}
