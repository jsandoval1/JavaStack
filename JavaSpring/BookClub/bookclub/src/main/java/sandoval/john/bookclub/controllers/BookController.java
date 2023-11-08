package sandoval.john.bookclub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import sandoval.john.bookclub.models.Book;
import sandoval.john.bookclub.services.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    // * Controller for displayig all of the books
    // localhost:8080/books
    // Displays table with all books and their details (including post by)
    // ! Add session check
    @GetMapping("/books")
    public String getAllBooks(Model model, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        } else {
            List<Book> books = bookService.findAllBooks();
            model.addAttribute("books", books);
            return "ViewAllBooks";
        }
    }

    // * Controllers to add a book
    // localhosy:8080/books/new
    // Displays the create a book page (Title, Author, My thougths)
    // ? Post or Put do not need session check
    @GetMapping("/books/new")
    public String createNewBook(Model model, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        } else {
            model.addAttribute("book", new Book());
            return "CreateNewBook";
        }
    }

    @PostMapping("/books/new")
    public String createBook(@Valid @ModelAttribute Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) { // ! If has errors
            return "CreateNewBook";
        } else {
            bookService.createBook(book); // * If no errors
            return "redirect:/books";
        }
    }

    // * Controller to display single book details
    // localhost8080/books/{booksId}
    // Displays the book details
    // ! Add session
    @GetMapping("books/{bookId}")
    public String getSingleBook(@PathVariable("bookId") Long bookId, Model model, HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        } else {
            Book singlebook = bookService.findBookById(bookId);
            model.addAttribute("book", singlebook);
            return "ViewSingleBook";
        }
    }
}
