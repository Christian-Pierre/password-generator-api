package com.dev.passwordgen.core.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tab_system_password")
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String systemOrigin;
    private String systemLogin;
    private String systemPassword;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getSystemOrigin() {
        return systemOrigin;
    }
    public void setSystemOrigin(String systemOrigin) {
        this.systemOrigin = systemOrigin;
    }
    public String getSystemLogin() {
        return systemLogin;
    }
    public void setSystemLogin(String systemLogin) {
        this.systemLogin = systemLogin;
    }
    public String getSystemPassword() {
        return systemPassword;
    }
    public void setSystemPassword(String systemPassword) {
        this.systemPassword = systemPassword;
    }
    
}
