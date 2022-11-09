package threephone.group.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import threephone.group.model.User;
import threephone.group.repository.IUserRepository;

import java.util.Optional;

@Service
public class UserServiceIMPL implements IUserService{
    @Autowired
    private IUserRepository userRepository;
    @Override
    public Boolean existsByUsername(String user) {
        return userRepository.existsByUsername(user);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
