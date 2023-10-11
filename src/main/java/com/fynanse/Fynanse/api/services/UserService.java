package com.fynanse.Fynanse.api.services;

import com.fynanse.Fynanse.api.models.Account;
import com.fynanse.Fynanse.api.repositories.AccountRepository;
import com.fynanse.Fynanse.api.repositories.UserRepository;
import com.fynanse.Fynanse.api.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
    public Optional<User> getUserById(String username){
        return userRepository.findById(username);
    }
    public Optional<User> getUser(String username){
        return userRepository.findById(username);
    }
    public Optional<User> getCurrentUser() {
        return userRepository.findByLoggedInTrue();
    }
    public void addUser(User user) {
        userRepository.save(user);
    }
    public void updateUser(String username, User user) {
        userRepository.save(user);
    }
    public void updateUser(User user) {
        userRepository.save(user);
    }
    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }
    public Account getAccount(String username){
        return accountRepository.findByUserUsername(username);
    }
    public void saveAccountInfo(Account account){
        accountRepository.save(account);
    }
}