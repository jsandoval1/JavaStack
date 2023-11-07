package sandoval.john.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sandoval.john.bookclub.models.Book;
import sandoval.john.bookclub.repositories.BookRepository;

@Service
public class BookService {

    // * Import the repository
    @Autowired
    private BookRepository bookRepository;

    // * Find all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // * Find a single Book
    public Book findBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    // *  Create a new Book
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
}
