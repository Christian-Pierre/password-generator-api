package com.dev.passwordgen.core.dto;

public class PasswordDTO {
    private String systemLogin;
    private String systemPassword;
    private String systemOrigin;

    //constructor
    public PasswordDTO(String systemOrigin, String systemLogin, String systemPassword) {
        this.systemOrigin = systemOrigin;
        this.systemLogin = systemLogin;
        this.systemPassword = systemPassword;
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

    public String getSystemOrigin() {
        return systemOrigin;
    }

    public void setSystemOrigin(String systemOrigin) {
        this.systemOrigin = systemOrigin;
    }    
}
