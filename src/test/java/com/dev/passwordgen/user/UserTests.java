package com.dev.passwordgen.user;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.dev.passwordgen.core.model.User;
import com.dev.passwordgen.core.service.UserService;

@SpringBootTest
public class UserTests {
    @Autowired UserService userService;

    @Test
    public void testUser(){
        Assert.notNull(userService.getUsers(), "Object list must be not null");
    }
    @Disabled
    @Test
    public void testInsertUser(){
        User u = new User();
        u.setUserName("test clean install");
        u.setUserPass("TestPass*123");
        u.setUserPassAuth("TestPassAuth321");
        Assert.notNull(userService.saveUser(u), "Object must be not null");
    }
}
