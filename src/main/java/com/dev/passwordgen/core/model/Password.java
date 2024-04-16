package com.dev.passwordgen.core.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Password")
@Getter @Setter
public class Password {
    @Column(name = "userId")
    private int userId;
    @Column(name = "passwordContents")
    private String contents;
    @Column(name = "passwordOrigin")
    private String passwordOrigin;
}
