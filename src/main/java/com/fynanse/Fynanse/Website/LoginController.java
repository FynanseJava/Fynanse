package com.fynanse.Fynanse.Website;

import com.fynanse.Fynanse.api.models.User;
import com.fynanse.Fynanse.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        User inputUser = new User();
        model.addAttribute("inputUser", inputUser);
        return "login";
    }

    @Autowired
    private UserService userService;

    @RequestMapping(path="/loginFormHandle", method = RequestMethod.POST)
    public String loginFormHandle(@ModelAttribute("inputUser") User inputUser) {
        Optional<User> storedUser = userService.getUserById(inputUser.getUsername()); //getting all the users
        if (storedUser.isEmpty()) {
            return "redirect:/login";
        }
        if (storedUser.get().getUserPassword().equals(inputUser.getUserPassword())) {
            storedUser.get().isLoggedIn = true;
            return "redirect:/dashboard";
        } else {
            return "redirect:/login";
        }
    }
}