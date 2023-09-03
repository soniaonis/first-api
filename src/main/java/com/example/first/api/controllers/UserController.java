package com.example.first.api.controllers;

import com.example.first.api.models.User;
import com.example.first.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {

        return userService.findById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {

        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        if (userService.existsById(id)) {
            user.setId(id);
            return userService.save(user);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteById (@PathVariable long id) {
        userService.deleteById(id);
    }
}
