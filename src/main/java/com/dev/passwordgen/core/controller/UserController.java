package com.dev.passwordgen.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.passwordgen.core.model.User;
import com.dev.passwordgen.core.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    //private final UserService userService = new UserService();
    @Autowired UserService userService;

    // @PostMapping
    // public ResponseEntity<User> addUser(@RequestBody User user){
    //     return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    // }
    
    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }
}
