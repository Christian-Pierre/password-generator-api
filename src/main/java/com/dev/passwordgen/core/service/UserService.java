package com.dev.passwordgen.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.passwordgen.core.model.User;
import com.dev.passwordgen.core.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;
    
    public UserService (UserRepository userRepository){
        this.repository = userRepository; 
    }
   
    public List<User> getUsers(){
        return repository.findAll();
    }
    public User saveUser(User user){
        return repository.save(user);
    }
}
