package sandoval.john.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sandoval.john.bookclub.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
}
