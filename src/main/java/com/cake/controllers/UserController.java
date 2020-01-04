package com.cake.controllers;

import com.cake.dtos.Credentials;
import com.cake.dtos.UserDto;
import com.cake.entities.User;
import com.cake.exceptions.CustomException;
import com.cake.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService = null;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = "application/json")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(produces = "application/json")
    @RequestMapping("/id/{id}")
    public User getUserById(@PathVariable Long id) {
        if(id == 0 || id == null) throw new CustomException("Invalid request", HttpStatus.BAD_REQUEST);
        return userService.getUserById(id);
    }

    @PostMapping(produces = "application/json")
    @RequestMapping("/auth")
    public User login(@RequestBody Credentials credentials) {
        if(credentials == null) throw new CustomException("Invalid request", HttpStatus.BAD_REQUEST);
        return userService.login(credentials.getEmail(), credentials.getPasswd());
    }

    @PostMapping(produces = "application/json")
    @RequestMapping("/register")
    public User registerUser(@RequestBody UserDto userDto) {
        if(userDto == null) throw new CustomException("Invalid request", HttpStatus.BAD_REQUEST);
        return userService.registerUser(userDto);
    }

}
