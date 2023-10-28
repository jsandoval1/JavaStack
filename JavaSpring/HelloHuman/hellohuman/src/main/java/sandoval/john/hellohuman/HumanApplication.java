package sandoval.john.hellohuman;
// ! Importing files in the same package are not necessary in java.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //! Needs to be annotated with @RestController because it will be used as a controller.
public class HumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanApplication.class, args);
	}

}