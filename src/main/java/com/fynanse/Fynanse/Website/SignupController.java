package com.fynanse.Fynanse.Website;

import com.fynanse.Fynanse.api.models.User;
import com.fynanse.Fynanse.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignupController {
    @Autowired
    private UserService userService;
    @GetMapping("/signup")
    public String showSignUp(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }
    @RequestMapping(path = "/signUpFormHanlde",
            method = RequestMethod.POST
    )
    public String addUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/login";
    }

}