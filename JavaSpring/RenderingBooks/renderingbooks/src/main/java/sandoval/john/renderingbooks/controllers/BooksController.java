package sandoval.john.renderingbooks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import sandoval.john.renderingbooks.models.Book;
import sandoval.john.renderingbooks.services.BookService;

@Controller
public class BooksController {

    @Autowired
    BookService bookService;

    // Handle HTTP GET requests to "/books"
    @GetMapping("/books")
    public String books(Model model) {
        // Retrieve a list of all books from the BookService
        // and add it to the Model for the view to access
        model.addAttribute("books", bookService.allBooks());

        // Return the view template named "ViewAllBooks"
        return "ViewAllBooks";
    }

    // Handle HTTP GET requests to "/books/{bookId}"
    @GetMapping("/books/{bookId}")
    public String viewBook(@PathVariable("bookId") Long bookId, Model model) {
        // Retrieve the book with the given bookId from the bookService and store it in the book variable."
        Book book = bookService.findBook(bookId);

        // Log the book object and the bookId to the console
        System.out.println("bookId: " + bookId);
        System.out.println("book: " + book);

        // Add the book object to the Model for the view to access
        model.addAttribute("book", book);

        // Return the view template named "ViewBook"
        return "ViewBook";
    }
}
