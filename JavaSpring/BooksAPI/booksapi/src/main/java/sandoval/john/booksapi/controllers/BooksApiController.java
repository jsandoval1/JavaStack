package sandoval.john.booksapi.controllers;
//! Responsible for handling HTTP requests and routes
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sandoval.john.booksapi.models.Book;
import sandoval.john.booksapi.services.BookService;

@RestController
public class BooksApiController {
    // Inject the BookService as a dependency
    private final BookService bookService;

    // Constructor to initialize the controller with the service
    public BooksApiController(BookService bookService) {
        this.bookService = bookService;
    }

    // Handle HTTP GET request to /api/books
    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }

    // Handle HTTP POST request to /api/books
    @RequestMapping(value = "/api/books", method = RequestMethod.POST)
    public Book create(@RequestParam(value = "title") String title, @RequestParam(value = "description") String desc,
                        @RequestParam(value = "language") String lang, @RequestParam(value = "pages") Integer numOfPages) {
                            System.out.println(title);
        // Create a new book and use the service to save it
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }

    // Handle HTTP GET request to /api/books/{id}
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        // Find and return a specific book by its ID
        Book book = bookService.findBook(id);
        return book;
    }
}
