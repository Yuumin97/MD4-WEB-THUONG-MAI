package threephone.group.service.user;

import threephone.group.model.User;

import java.util.Optional;

public interface IUserService {
    Boolean existsByUsername(String user);
    Boolean existsByEmail(String email);
    void save(User user);
    Optional<User> findByUsername(String username);

}
