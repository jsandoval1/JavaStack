package sandoval.john.server.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sandoval.john.server.models.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
    // * Find a role by name
    List<Role> findByName(String name);
}
