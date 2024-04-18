package com.dev.passwordgen.core.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tab_password")
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passwordId;
    private int userId;
    private String passwordContents;
    private String passwordOrigin;
    
    public Long getPasswordId() {
        return passwordId;
    }
    public void setPasswordId(Long passwordId) {
        this.passwordId = passwordId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getPasswordContents() {
        return passwordContents;
    }
    public void setPasswordContents(String passwordContents) {
        this.passwordContents = passwordContents;
    }
    public String getPasswordOrigin() {
        return passwordOrigin;
    }
    public void setPasswordOrigin(String passwordOrigin) {
        this.passwordOrigin = passwordOrigin;
    }
    
}
