package com.dev.passwordgen.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.passwordgen.core.model.Account;
import com.dev.passwordgen.core.repository.UserRepository;

@Service
public class UserService {

    @Autowired private UserRepository repository;
    
    public List<Account> getUsers(){
        return repository.findAll();
    }
    public Optional<Account> getUser(Long id){
        return repository.findById(id);
    }
    public Account saveUser(Account user){
        return repository.save(user);
    }
}
