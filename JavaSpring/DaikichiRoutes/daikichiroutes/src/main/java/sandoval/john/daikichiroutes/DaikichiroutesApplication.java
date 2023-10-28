package sandoval.john.daikichiroutes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
@RequestMapping("/Daikichi")
// Class level annotation
public class DaikichiroutesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaikichiroutesApplication.class, args);
	}

	// Method Level Annotation
	@RequestMapping("/")
	public String index() {
		return "Welcome!";
	}

	@RequestMapping("/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}

	@RequestMapping("tomorrow")
	public String tomorrow() {
        return "Tomorrow, an oppurtunity will arise, so be sure to be open to new ideas!";
    }
}
