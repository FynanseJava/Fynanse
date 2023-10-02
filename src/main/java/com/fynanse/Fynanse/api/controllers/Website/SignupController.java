package com.fynanse.Fynanse.api.controllers.Website;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignupController{
    @GetMapping("/")
    public String showLogin(){
        return "login";
    }
    @GetMapping("/signup")
    public String showSignup(){
        return "signup";
    }
}
