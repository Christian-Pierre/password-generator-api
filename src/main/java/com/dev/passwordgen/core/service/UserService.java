package com.dev.passwordgen.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.passwordgen.core.repository.UserRepository;
import com.dev.passwordgen.core.model.User;

@Service
public class UserService {
    private final UserRepository repository;
    public UserService (UserRepository userRepository){
        this.repository = userRepository; 
    }
    // @Autowired private UserRepository userRepository;

    // private final StatusService service;
    // public statusController (StatusService statusService){
    //     this.service = statusService;
    // }

    // public User saveUser(User user){
    //     return userRepository.save(user);
    // }
    public List<User> getUsers(){
        return repository.findAll();
    }
}
