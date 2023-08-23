package com.example.first.api.services;

import com.example.first.api.models.CUser;
import com.example.first.api.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CUserService {
    private final IUserRepository userRepository;

    @Autowired
    public CUserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<CUser> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<CUser> getUserById(int id) {
        return userRepository.findById(id);
    }

    public CUser createUser(CUser user) {
        return userRepository.save(user);
    }

    public CUser updateUser(int id, CUser user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
