package cinema.spring.dao;

import java.util.Optional;
import cinema.spring.model.User;

public interface UserDao {
    User add(User user);

    Optional<User> get(Long id);

    Optional<User> findByEmail(String email);
}
