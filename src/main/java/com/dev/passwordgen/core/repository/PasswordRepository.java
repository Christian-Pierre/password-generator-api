package com.dev.passwordgen.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.passwordgen.core.model.Password;

@Repository
public interface PasswordRepository extends JpaRepository<Password , Long>{
    List<Password> findByUserId(Long userId);
}
