package com.dev.passwordgen.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.dev.passwordgen.core.service.UserService;

@SpringBootTest
public class UserTests {
    @Autowired UserService userService;

    @Test
    public void testUser(){
        Assert.notNull(userService.getUsers(), "Object list must be not null");
    }

    

}
