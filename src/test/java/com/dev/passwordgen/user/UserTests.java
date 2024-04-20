package com.dev.passwordgen.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.dev.passwordgen.core.model.User;
import com.dev.passwordgen.core.repository.UserRepository;
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
    @Test 
    public void testUserMock(){
        // Criando um mock para UserRepository
        UserRepository mockUserRepository = Mockito.mock(UserRepository.class);

        // Configurando o comportamento esperado do mock
        User newUser = new User();
        newUser.setUserName("mockuser");
        newUser.setUserPass("mockuserPass*123");
        newUser.setUserPassAuth("mock*Auth/321");

        User savedUser = new User();
        savedUser.setUserId(1);
        savedUser.setUserName("mockuser");
        savedUser.setUserPass("mockuserPass*123");
        savedUser.setUserPassAuth("mock*Auth/321");

        when(mockUserRepository.save(newUser)).thenReturn(savedUser);

        // Criando uma instância de UserService com o mock
        //UserService userService = new UserService(mockUserRepository);
        
        UserService uService = new UserService(mockUserRepository);

        // Chamando o método createUser() e verificando o resultado
        User createdUser = uService.saveUser(newUser);

        assertEquals(savedUser.getUserId(), createdUser.getUserId());
        assertEquals(savedUser.getUserName(), createdUser.getUserName());
        assertEquals(savedUser.getUserPass(), createdUser.getUserPass());
        assertEquals(savedUser.getUserPassAuth(), createdUser.getUserPassAuth());

    }
}
