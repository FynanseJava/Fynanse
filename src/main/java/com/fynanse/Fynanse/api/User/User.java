package com.fynanse.Fynanse.api.User;

import jakarta.persistence.*;

@Entity
@Table(name="USER")
public class User {
    private int id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "USER_PASSWORD")
    private String userPassword;
    @Column(name = "FIRST_NAME")
    public String firstName;
    @Column(name = "LAST_NAME")
    public String lastName;
    public User(){
        System.out.println("User object created");
    }
    public User(String username, String email, String password, String firstName, String lastName) {
        this.username = username;
        this.email = email;
        this.userPassword = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String password) {
        this.userPassword = password;
    }
}