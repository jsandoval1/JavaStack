package sandoval.john.server.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sandoval.john.server.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long>{
    // * Find all comments
    List<Comment> findAll();
}