package sandoval.john.booksapi.services;
//! Responsible for managing business/DB logic related to books
//? Reponsible for high-level business logic. It 
//? performs operations involving one or more 
//? entities, applies business rules, and 
//? provides an interface to the controller
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import sandoval.john.booksapi.models.Book;
import sandoval.john.booksapi.repositories.BookRepository;

// Define a service class for managing business logic related to books
@Service
public class BookService {
    // Inject the BookRepository as a dependency
    private final BookRepository bookRepository;

    // Constructor to initialize the service with the repository
    BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Method to retrieve all books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    // Method to create a new book and save it to the database
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }

    // Method to find a book by its ID
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null; // Book not found
        }
    }
}
