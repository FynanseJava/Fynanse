package com.fynanse.Fynanse.api.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers(){
        List<User> users = null;
        for (User user : userRepository.findAll()) {
            users.add(user);
        }
        return users;
    }
    public Optional<User> getUser(int id){
        return userRepository.findById(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(long id, User user) {
        userRepository.save(user);
    }
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}