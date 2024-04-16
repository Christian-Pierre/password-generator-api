package com.dev.passwordgen.core.model;


import jakarta.persistence.Column;
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
    @Column(name = "passwordId")
    private Long id;
    @Column(name = "userId")
    private int userId;
    @Column(name = "passwordContents")
    private String contents;
    @Column(name = "passwordOrigin")
    private String passwordOrigin;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getContents() {
        return contents;
    }
    public void setContents(String contents) {
        this.contents = contents;
    }
    public String getPasswordOrigin() {
        return passwordOrigin;
    }
    public void setPasswordOrigin(String passwordOrigin) {
        this.passwordOrigin = passwordOrigin;
    }
    
}
