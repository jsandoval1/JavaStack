package sandoval.john.bookclub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import sandoval.john.bookclub.models.Book;
import sandoval.john.bookclub.services.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    // Controller for displayig all of the books 
    // localhost:8080/books
    // Displays table with all books and their details (including post by)
    // ! Add session check
    @GetMapping("/books")
    public String getAllBooks(Model model, HttpSession session){
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        } else {
            List<Book> books = bookService.findAllBooks();
            model.addAttribute("books", books);
            return "ViewAllBooks";
        }
    }

    // Controller to add a book
    // localhosy:8080/books/new
    // Displays the create a book page (Title, Author, My thougths)
    // ? Post or Put do not need session check

    // Controller to display book details
    // localhost8080/books/{booksId}
    // Displays the book details
    // ! Add session book
}
