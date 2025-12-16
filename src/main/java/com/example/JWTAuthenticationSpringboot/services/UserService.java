package com.example.JWTAuthenticationSpringboot.services;

import com.example.JWTAuthenticationSpringboot.models.User;
import com.example.JWTAuthenticationSpringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
