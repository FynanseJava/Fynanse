package com.fynanse.Fynanse.api.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers(){
        List<User> users = null;
        userRepository.findAll().forEach(users::add);
        return users;
    }
    public User getUserByID(long id){
        User theUser = null;
        for (User user : users) {
            if(user.getId() == id){
                theUser = user;
            }
        }
        return theUser;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(long id, User user) {
        for (int i=0; i<users.size(); i++) {
            User u = users.get(i);
            if(u.getId() == id){
                users.set(i, user);
                return;
            }
        }
    }
    public void deleteUser(long id) {
        users.removeIf(user -> user.getId() == id);
    }
}