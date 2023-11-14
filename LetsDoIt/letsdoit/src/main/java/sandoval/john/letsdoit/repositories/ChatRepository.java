package sandoval.john.letsdoit.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sandoval.john.letsdoit.models.Chat;
import sandoval.john.letsdoit.models.User;

public interface ChatRepository extends CrudRepository<Chat, Long> {

    // * Find all messages sent by a user
    List<Chat> findByUser(User user);
    
}
