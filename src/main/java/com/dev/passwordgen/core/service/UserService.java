package com.dev.passwordgen.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.passwordgen.core.model.User;
import com.dev.passwordgen.core.repository.UserRepository;

@Service
public class UserService {

    @Autowired private UserRepository repository;
    
    public List<User> getUsers(){
        return repository.findAll();
    }
    public Optional<User> getUser(Long id){
        return repository.findById(id);
    }
    public User saveUser(User user){
        return repository.save(user);
    }
}
