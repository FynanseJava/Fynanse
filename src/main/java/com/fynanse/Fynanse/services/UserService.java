package com.fynanse.Fynanse.services;

import com.fynanse.Fynanse.models.Account;
import com.fynanse.Fynanse.repositories.AccountRepository;
import com.fynanse.Fynanse.repositories.UserRepository;
import com.fynanse.Fynanse.models.User;
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
    public void addUser(User user) {
        userRepository.save(user);
    }
    public void updateUser(User user) {
        userRepository.save(user);
    }
    public void deleteUser(User user) {
        userRepository.delete(user);
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