package sandoval.john.booksapi.repositories;

//! Responsible for being entry point of  DB operations
// ? responsible for low-level database interactions, 
//? such as reading and writing data to and from the 
//? database. Usually CRUD operations and querying the database.
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sandoval.john.booksapi.models.Book;

// Define a repository interface for managing Book entities
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    // Method to retrieve all books from the database
    List<Book> findAll();

    // Method to find books with descriptions containing the search string
    List<Book> findByDescriptionContaining(String search);

    // Method to count how many titles contain a certain string
    Long countByTitleContaining(String search);

    // Method to delete a book that starts with a specific title
    Long deleteByTitleStartingWith(String search);
}
