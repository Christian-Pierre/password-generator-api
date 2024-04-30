package com.dev.passwordgen.user;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dev.passwordgen.core.model.Account;
import com.dev.passwordgen.core.repository.UserRepository;
import com.dev.passwordgen.core.service.UserService;

@ExtendWith(MockitoExtension.class)
public class MockUserServiceTests {
    @Mock private UserRepository userRepository;
    @InjectMocks private UserService userService;

    @Test
    public void UserService_CreateUser_ReturnsUser(){
        Account newUser = new Account();
        newUser.setUserName("mockUser");
        newUser.setUserPass("Mock*pass*123");
        newUser.setUserPassAuth("Mock*Auth");

        //comportamento do mock
        when(userRepository.save(Mockito.any(Account.class))).thenReturn(newUser);

        Account savedUser = userService.saveUser(newUser);

        Assertions.assertThat(savedUser).isNotNull();
    }
    @Test
    public void UserService_GetUser_ReturnUser(){
        Account expectedUser = new Account();
        Long userId = 1L;
        expectedUser.setId(userId);
        expectedUser.setUserName("mockUser1");
        expectedUser.setUserPass("Mock*pass*123");
        expectedUser.setUserPassAuth("Mock*Auth");

        when(userRepository.findById(1L)).thenReturn(Optional.of(expectedUser));

        Optional<Account> actualUser = userService.getUser(userId);

        Assertions.assertThat(actualUser).isPresent().contains(expectedUser);
    }
    @Test
    public void UserService_GetUser_ReturnEmpty(){
        Long userId = 2L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());
        Optional<Account> actualUser = userService.getUser(userId);
        Assertions.assertThat(actualUser).isEmpty();
    }
    @Test
    public void UserService_GetUsers_ReturnUsers(){
        //arranjo
        Account u1 = new Account();
        u1.setUserName("mockUser1");
        u1.setUserPass("Mock*pass*123");
        u1.setUserPassAuth("Mock*Auth");

        Account u2 = new Account();
        u2.setUserName("mockUser1");
        u2.setUserPass("Mock*pass*123");
        u2.setUserPassAuth("Mock*Auth");

        Account u3 = new Account();
        u3.setUserName("mockUser1");
        u3.setUserPass("Mock*pass*123");
        u3.setUserPassAuth("Mock*Auth");

        List<Account> expectedUsers = Arrays.asList(u1,u2,u3);

        //comportamento do mock
        when(userRepository.findAll()).thenReturn(expectedUsers);

        //metodo a ser testado
        List<Account> actualUsers = userService.getUsers();

        // Verificando se o método findAll() foi chamado no mock
        verify(userRepository).findAll();
        Assertions.assertThat(expectedUsers).isEqualTo(actualUsers);
    }
}
