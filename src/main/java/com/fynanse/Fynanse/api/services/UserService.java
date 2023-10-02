package com.fynanse.Fynanse.api.services;

import com.fynanse.Fynanse.api.repositories.UserRepository;
import com.fynanse.Fynanse.api.models.User;
import com.fynanse.Fynanse.api.repositories.UserRepository;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            users.add(user);
        }
        return users;
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
    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }
}