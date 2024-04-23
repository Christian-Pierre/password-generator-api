package com.dev.passwordgen.core.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.passwordgen.core.dto.PasswordDTO;
import com.dev.passwordgen.core.dto.PasswordGeneratedDTO;
import com.dev.passwordgen.core.model.Password;
import com.dev.passwordgen.core.repository.PasswordRepository;

@Service
public class PasswordService {
    @Autowired private PasswordRepository repository;
    
    public PasswordGeneratedDTO generatePassword(){
        PasswordGeneratedDTO passwordDto = new PasswordGeneratedDTO();
        passwordDto.setPassword(RandomStringUtils.randomAlphanumeric(10));
        return passwordDto;
    }

    public boolean numberContent(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
    public boolean lowercaseContent(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }
    public boolean uppercaseContent(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }
    public boolean specialContent(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                // Se o caractere não for letra, dígito ou espaço em branco, consideramos como caractere especial
                return true;
            }
        }
        return false;
    }
    
    public boolean lengthContent(String str) {
        return str.length() >= 15;
    }

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
