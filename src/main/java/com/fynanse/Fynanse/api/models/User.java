package com.fynanse.Fynanse.api.models;

import jakarta.persistence.*;

@Entity
@Table(name="USER")
public class User {
    @Id
    @Column(nullable = false, unique = true)
    private String username;
    private String userPassword;

    public Boolean isLoggedIn = false;
    public User(){
        System.out.println("User object created");
    }
    public User(String username,  String password) {
        this.username = username;
        this.userPassword = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String password) {
        this.userPassword = password;
    }
}