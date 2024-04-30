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

import com.dev.passwordgen.core.model.Account;
import com.dev.passwordgen.core.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired UserService userService;    
    @GetMapping
    public ResponseEntity<List<Account>> getUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Account> addUser(@RequestBody Account user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }
}
