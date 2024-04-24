package com.dev.passwordgen.core.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.passwordgen.core.dto.PasswordDTO;
import com.dev.passwordgen.core.model.Password;
import com.dev.passwordgen.core.repository.PasswordRepository;

@Service
public class PasswordService {
    @Autowired private PasswordRepository repository; 
    //repository functions
    public List<PasswordDTO> getPassword(Long userId){

        List<Password> actualPasswords = repository.findByUserId(userId);

        List<PasswordDTO> passwordDTOList = actualPasswords.stream().map(
            password -> new PasswordDTO(password.getPasswordOrigin(), password.getPasswordContents())
            ).collect(Collectors.toList());

        return passwordDTOList;
    }

    public Password savePassword(Password password){
        return repository.save(password);
    }
    
}
