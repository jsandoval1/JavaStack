package sandoval.john.daikichiroutes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController
@RequestMapping("/hello")
public class DaikichiroutesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaikichiroutesApplication.class, args);
	}

	 // 1. Annotation
        @RequestMapping("")
        // 3. Method that maps to the request route above
        public String index() { // 3
			return "Hello World!";
        }
		@RequestMapping("/world")
		public String world() {
            return "Class level annotations are cool too!";
        }
}
