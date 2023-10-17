package com.fynanse.Fynanse.controllers;

import com.fynanse.Fynanse.models.User;
import com.fynanse.Fynanse.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class LogoutController {
    @Autowired
    private UserService userService;
    @GetMapping("/logout")
    public String userLogout(HttpServletRequest request){
        Optional<User> currentUser = userService.getCurrentUser(request);
        if(currentUser.isEmpty()){
            return "redirect:/login";
        }
        //ending the current session of the User
        HttpSession session = request.getSession();
        session.setAttribute("currentUser", null);
        session.invalidate();
        userService.updateUser(currentUser.get());
        return "redirect:/login";
    }
}