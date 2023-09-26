package com.fynanse.Fynanse.api.User;

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
        return userService.getUser(username);
    }

    @RequestMapping(method=RequestMethod.POST, value="/api/users")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/api/users/{username}")
    public void deleteUser(@PathVariable String username){
        userService.deleteUser(username);
    }
}