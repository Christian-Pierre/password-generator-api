package com.dev.passwordgen.password;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.dev.passwordgen.core.service.ValidationRulesService;

@SpringBootTest
public class ValidationRulesTest {
    @Autowired ValidationRulesService service;
    
    @Test
    public void testValidPass(){
        Assert.isTrue(service.numberContent("senha123"), "Password must be alfanumeric");
        Assert.isTrue(service.lowercaseContent("senha"), "Password mus be one lowercase character");
        Assert.isTrue(service.uppercaseContent("Senha123"), "Password must be one uppercase character");
        Assert.isTrue(service.specialContent("$Enha123"), "Password must be one special character");
        Assert.isTrue(service.lengthContent("$Enha1234567890"), "Password must be contain 15 characters");
    }
    
}
