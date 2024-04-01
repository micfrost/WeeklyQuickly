package dev.micfro.weeklyquickly.service;

import dev.micfro.weeklyquickly.model.Authority;
import dev.micfro.weeklyquickly.model.User;
import dev.micfro.weeklyquickly.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    // CRUD

    // save user
    public void saveUser(User user) {
        userRepository.save(user);
    }



    public User createUser(String username, String password, String authorityRole) {
        Authority authority = new Authority(username, authorityRole);

        User user = new User(username, password, true, authority);
        return userRepository.save(user); // Save and return the user
    }

    // Read
    public List<User> findAll() {
        return userRepository.findAll();
    }

}