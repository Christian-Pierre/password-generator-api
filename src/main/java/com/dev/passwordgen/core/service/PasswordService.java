package com.dev.passwordgen.core.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.dev.passwordgen.core.model.Password;

@Service
public class PasswordService {
    Password password = new Password();
    
    public Password generatePassword(){
        password.setContents(RandomStringUtils.randomAlphanumeric(10));
        return password;
    }
    
}
