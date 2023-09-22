package com.fynanse.Fynanse.api.User;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    private List<User> users = new ArrayList<>(Arrays.asList(
            new User(0, "daiyaan", "email@email.com", "password", "Daiyaan", "Fardeen"),
            new User(1, "nasim", "nasim@email.com", "nasim", "Nasim", "Parvez"),
            new User(2, "bishal", "bishal@email.com", "bishal", "Bishal", "Achariya")
    ));
    public List<User> getAllUsers(){
        return users;
    }
    public User getUserByID(long id){
        User theUser = null;
        for (User user : users) {
            if(user.getID() == id){
                theUser = user;
            }
        }
        return theUser;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void updateUser(long id, User user) {
        for (int i=0; i<users.size(); i++) {
            User u = users.get(i);
            if(u.getID() == id){
                users.set(i, user);
                return;
            }
        }
    }
    public void deleteUser(long id) {
        users.removeIf(user -> user.getID() == id);
    }
}