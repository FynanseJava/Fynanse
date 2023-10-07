package com.fynanse.Fynanse.Website;

import com.fynanse.Fynanse.api.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {
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
    public String showSignUp(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    @GetMapping("/signup_success")
    public String showSuccess(){
        return "signup_success";
    }
}