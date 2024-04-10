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
}
