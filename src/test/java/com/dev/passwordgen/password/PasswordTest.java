package com.dev.passwordgen.password;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.dev.passwordgen.core.model.Password;
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
    @Disabled
    @Test
    public void testInserPassword(){
        Password testPass = new Password();
        testPass.setUserId(1);
        testPass.setPasswordOrigin("Password of System Origin (Test)");
        testPass.setPasswordContents("Hw*8119900403121999");
        Assert.notNull(passwordService.savePassword(testPass), "Password object must be not null");
    }
    @Test 
    public void testGetPassword(){
        Assert.notNull(passwordService.getPassword(1), "Password object must be exists");
    }
}
