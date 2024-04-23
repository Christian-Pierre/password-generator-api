package com.dev.passwordgen.core.dto;

public class PasswordDTO {
    private String passwordContents;
    private String passwordOrigin;

    //constructor
    public PasswordDTO(String passwordContents, String passwordOrigin){
        this.passwordContents = passwordContents;
        this.passwordOrigin = passwordOrigin;
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
