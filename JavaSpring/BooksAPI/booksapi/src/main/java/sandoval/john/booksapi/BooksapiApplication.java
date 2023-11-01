package sandoval.john.booksapi;
//! Responsible for running Spring Boot application
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksapiApplication.class, args);
	}

}
