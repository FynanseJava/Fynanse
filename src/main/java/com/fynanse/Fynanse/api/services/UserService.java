package com.fynanse.Fynanse.api.services;

import com.fynanse.Fynanse.api.models.Account;
import com.fynanse.Fynanse.api.repositories.AccountRepository;
import com.fynanse.Fynanse.api.repositories.UserRepository;
import com.fynanse.Fynanse.api.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public Optional<User> getUserById(String username){
        return userRepository.findById(username);
    }
    public Optional<User> getUser(String username){
        return userRepository.findById(username);
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
    public Optional<User> getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String currentUsername = (String) session.getAttribute("currentUsername");
        if(currentUsername == null){
            currentUsername = "";
        }
        return userRepository.findById(currentUsername);
    }
}