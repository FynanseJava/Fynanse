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
    private final List<User> users_OLD = new ArrayList<>(Arrays.asList(
            new User("daiyaan", "email@email.com", "password", "Daiyaan", "Fardeen"),
            new User("nasim", "nasim@email.com", "nasim", "Nasim", "Parvez"),
            new User("bishal", "bishal@email.com", "bishal", "Bishal", "Achariya")
    ));
    public List<User> getAllUsers(){
        List<User> users = null;
        userRepository.findAll().forEach(users::add);
        return users;
    }
    public Optional<User> getUser(long id){
        return userRepository.findById(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(long id, User user) {
        userRepository.save(user);
    }
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}