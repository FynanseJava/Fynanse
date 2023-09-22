package com.fynanse.Fynanse.Website;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/")
    public String showHome(){
        boolean isUserSignedIn = false;
        if(isUserSignedIn){
            return "home";
        }
        else{
            return "login";
        }
    }
    @GetMapping("/signup")
    public String showSignUp(){
        return "signup";
    }
}