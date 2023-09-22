package com.fynanse.Fynanse.api.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/api/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/api/users/{id}")
    public User getUserByID(@PathVariable int id){
        return userService.getUser(id);
    }

    @RequestMapping(method=RequestMethod.POST, value="/api/users")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/api/users/{id}")
    public void addUserByID(@RequestBody User user, @PathVariable long id){
        userService.updateUser(id, user);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/api/users/{id}")
    public void deleteUser(@PathVariable long id){
        userService.deleteUser(id);
    }
}