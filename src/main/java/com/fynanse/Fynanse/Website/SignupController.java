package com.fynanse.Fynanse.Website;

import com.fynanse.Fynanse.api.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignupController {
    @GetMapping("/signup")
    public String showSignUp(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

}