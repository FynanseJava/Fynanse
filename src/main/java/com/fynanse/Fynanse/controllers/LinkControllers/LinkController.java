package com.fynanse.Fynanse.controllers.LinkControllers;

import com.fynanse.Fynanse.models.User;
import com.fynanse.Fynanse.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Optional;

@Controller
public class LinkController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
//    @GetMapping("/error")
//    public String showErrorPage(){
//        return "error";
//    }
    @GetMapping("/about")
    public String showAboutPage() {
        return "about";
    }
}