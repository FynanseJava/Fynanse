package com.fynanse.Fynanse.Website;

import com.fynanse.Fynanse.api.models.User;
import com.fynanse.Fynanse.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class LogoutController {
    @Autowired
    private UserService userService;
    @GetMapping("/logout")
    public String userLogout(){
        Optional<User> currentUser = userService.getCurrentUser();
        if(currentUser.isEmpty()){
            return "redirect:/login";
        }
        currentUser.get().setLoggedIn(false);
        userService.updateUser(currentUser.get());
        return "redirect:/login";
    }
}