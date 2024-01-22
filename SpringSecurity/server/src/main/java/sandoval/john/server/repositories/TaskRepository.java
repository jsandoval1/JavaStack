package sandoval.john.server.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sandoval.john.server.models.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
    // * Find all tasks
    List<Task> findAll();
}