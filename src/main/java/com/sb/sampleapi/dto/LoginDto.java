package com.sb.sampleapi.dto;


public class LoginDto {
    private String usename;
    private String password;

    public LoginDto() {

    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


