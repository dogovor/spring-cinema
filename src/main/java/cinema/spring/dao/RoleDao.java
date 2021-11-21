package cinema.spring.dao;

import java.util.Optional;
import cinema.spring.model.Role;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getRoleByName(String roleName);
}
