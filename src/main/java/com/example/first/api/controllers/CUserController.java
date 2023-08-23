package com.example.first.api.controllers;

import com.example.first.api.models.CUser;
import com.example.first.api.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class CUserController {
    private final IUserRepository userRepository;

    @Autowired
    public CUserController(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping
    public List<CUser> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CUser> getUserById(@PathVariable int id) {
        return userRepository.findById(id);
    }

    @PostMapping
    public CUser createUser(@RequestBody CUser user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public CUser updateUser(@PathVariable int id, @RequestBody CUser user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }
}
