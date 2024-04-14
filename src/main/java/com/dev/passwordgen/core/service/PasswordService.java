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
    
}
