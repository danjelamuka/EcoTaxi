package com.example.EcoTaxi.model;


//	API-ja  bëhet më e lehtë për t'u përdorur; pret vetëm atë që i duhet.

public class LoginRequest {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}