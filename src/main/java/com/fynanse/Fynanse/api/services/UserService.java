package com.fynanse.Fynanse.api.services;

<<<<<<< HEAD:src/main/java/com/fynanse/Fynanse/api/services/UserService.java
import com.fynanse.Fynanse.api.repositories.UserRepository;
import com.fynanse.Fynanse.api.models.User;
import com.fynanse.Fynanse.api.repositories.UserRepository;
=======
import jakarta.persistence.metamodel.SingularAttribute;
>>>>>>> 56fb085404c8c3f0f351e8ecb4847c6af60fa636:src/main/java/com/fynanse/Fynanse/api/User/UserService.java
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
<<<<<<< HEAD:src/main/java/com/fynanse/Fynanse/api/services/UserService.java
    public Optional<User> getUserById(String username){
=======
    public Optional<User> getUser(String username){
>>>>>>> 56fb085404c8c3f0f351e8ecb4847c6af60fa636:src/main/java/com/fynanse/Fynanse/api/User/UserService.java
        return userRepository.findById(username);
    }
    public void addUser(User user) {
        userRepository.save(user);
    }

<<<<<<< HEAD:src/main/java/com/fynanse/Fynanse/api/services/UserService.java
    public void updateUser(String username, User user) {
        userRepository.save(user);
    }
=======
>>>>>>> 56fb085404c8c3f0f351e8ecb4847c6af60fa636:src/main/java/com/fynanse/Fynanse/api/User/UserService.java
    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }
}