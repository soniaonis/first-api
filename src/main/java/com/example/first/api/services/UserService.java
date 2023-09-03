package com.example.first.api.services;

import com.example.first.api.models.User;
import com.example.first.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User save (User user) {
        return userRepository.save(user);
    }

    public boolean existsById (Long id) {
        return userRepository.existsById(id);
    }
    public User updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(Math.toIntExact(id));
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteById (Long id) {
        userRepository.deleteById(id);
    }

}
