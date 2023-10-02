package com.fynanse.Fynanse.api.controllers;

import com.fynanse.Fynanse.api.models.User;
import com.fynanse.Fynanse.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/api/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/api/users/{username}")
    public Optional<User> getUserByID(@PathVariable String username){
<<<<<<< HEAD:src/main/java/com/fynanse/Fynanse/api/controllers/UserController.java
        return userService.getUserById(username);
=======
        return userService.getUser(username);
>>>>>>> 56fb085404c8c3f0f351e8ecb4847c6af60fa636:src/main/java/com/fynanse/Fynanse/api/User/UserController.java
    }
    @RequestMapping(method=RequestMethod.POST, value="/api/users")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

<<<<<<< HEAD:src/main/java/com/fynanse/Fynanse/api/controllers/UserController.java
    @RequestMapping(method=RequestMethod.PUT, value="/api/users/{username}")
    public void updateUser(@RequestBody User user, @PathVariable String username){
        userService.updateUser(username, user);
    }

=======
>>>>>>> 56fb085404c8c3f0f351e8ecb4847c6af60fa636:src/main/java/com/fynanse/Fynanse/api/User/UserController.java
    @RequestMapping(method=RequestMethod.DELETE, value="/api/users/{username}")
    public void deleteUser(@PathVariable String username){
        userService.deleteUser(username);
    }
}