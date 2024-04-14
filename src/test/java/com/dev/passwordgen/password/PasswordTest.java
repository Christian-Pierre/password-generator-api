package com.dev.passwordgen.password;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.dev.passwordgen.core.service.PasswordService;

@SpringBootTest
public class PasswordTest {
    @Autowired
    PasswordService passwordService;

    @Test
    public void testPassGen(){
        Assert.notNull(passwordService.generatePassword(), "The class must be not null");
    }
    @Test
    public void testValidPass(){
        Assert.isTrue(passwordService.numberContent("senha123"), "Password must be alfanumeric");
        Assert.isTrue(passwordService.lowercaseContent("senha"), "Password mus be one lowercase character");
        Assert.isTrue(passwordService.uppercaseContent("Senha123"), "Password must be one uppercase character");
        Assert.isTrue(passwordService.specialContent("$Enha123"), "Password must be one special character");
        Assert.isTrue(passwordService.lengthContent("$Enha1234567890"), "Password must be contain 15 characters");
    }
}
