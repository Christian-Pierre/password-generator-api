package com.dev.passwordgen.user;

import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dev.passwordgen.core.model.User;
import com.dev.passwordgen.core.repository.UserRepository;
import com.dev.passwordgen.core.service.UserService;

@ExtendWith(MockitoExtension.class)
public class MockUserServiceTests {
    @Mock private UserRepository userRepository;
    @InjectMocks UserService userService;

    @Test
    public void UserService_CreateUser_ReturnsUser(){
        User newUser = new User();
        newUser.setUserName("mockUser");
        newUser.setUserPass("Mock*pass*123");
        newUser.setUserPassAuth("Mock*Auth");

        when(userRepository.save(Mockito.any(User.class))).thenReturn(newUser);

        User savedUser = userService.saveUser(newUser);

        Assertions.assertThat(savedUser).isNotNull();
    }
}
