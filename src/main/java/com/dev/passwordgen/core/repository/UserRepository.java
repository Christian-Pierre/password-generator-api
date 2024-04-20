package com.dev.passwordgen.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.passwordgen.core.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}