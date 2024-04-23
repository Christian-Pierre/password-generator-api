package com.dev.passwordgen.password;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dev.passwordgen.core.model.Password;
import com.dev.passwordgen.core.repository.PasswordRepository;
import com.dev.passwordgen.core.service.PasswordService;

@ExtendWith(MockitoExtension.class)
public class MockPasswordTests {
    @Mock private PasswordRepository passwordRepository;
    @InjectMocks private PasswordService passwordService;
    private Long userId = 1L;

    
    @Test
    public void PasswordService_GetPassword_ReturnPassword(){

        Password expectedPassword1 = new Password();
        expectedPassword1.setPasswordId(1L);
        expectedPassword1.setUserId(this.userId);
        expectedPassword1.setPasswordContents("XyZ123abc789");
        expectedPassword1.setPasswordOrigin("Mock Tests");

        Password expectedPassword2 = new Password();
        expectedPassword2.setPasswordId(1L);
        expectedPassword2.setUserId(userId);
        expectedPassword2.setPasswordContents("HYc845sad321");
        expectedPassword2.setPasswordOrigin("Mock Tests");

        List<Password> expectedPasswords = Arrays.asList(expectedPassword1,expectedPassword2);
        
        when(passwordRepository.findByUserId(userId)).thenReturn(expectedPasswords);

        List<Password> actualPasswords = passwordService.getPassword(userId);
        verify(passwordRepository).findByUserId(userId);

        Assertions.assertThat(expectedPasswords).isEqualTo(actualPasswords);
    }
    
    @Test
    public void PasswordService_CreatePassword_ReturnPassword(){
        Password newPassword = new Password();

        newPassword.setUserId(this.userId);
        newPassword.setPasswordContents("XyZ123abc789");
        newPassword.setPasswordOrigin("Mock Create Test");

        when(passwordRepository.save(Mockito.any(Password.class))).thenReturn(newPassword);

        Password savedPassword = passwordService.savePassword(newPassword);

        Assertions.assertThat(savedPassword).isNotNull();
        Assertions.assertThat(savedPassword).isEqualTo(newPassword);
    }
}
