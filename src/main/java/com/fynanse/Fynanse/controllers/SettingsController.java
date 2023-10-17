package com.fynanse.Fynanse.controllers;

import com.fynanse.Fynanse.models.User;
import com.fynanse.Fynanse.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class SettingsController {

    @Autowired
    private UserService userService;
    @RequestMapping(path = "/updateUserInfo", method = RequestMethod.PUT)
    public String updateUserInfo(HttpServletRequest request, Model model, @ModelAttribute("updatedUser") User updatedUser){
        Optional<User> currentUser = userService.getCurrentUser(request);
        if(currentUser.isEmpty()){
            return "redirect:/login";
        }
        userService.updateUser(updatedUser.getUsername(), updatedUser);
        return "redirect:/dashboard";
    }

    @RequestMapping(path = "/deleteCurrentUser", method = RequestMethod.DELETE)
    public String deleteCurrentUser(HttpServletRequest request){
        Optional<User> currentUser = userService.getCurrentUser(request);
        if(currentUser.isEmpty()){
            return "redirect:/login";
        }
        userService.deleteUser(currentUser.get().getUsername());
        return "redirec:/login";

    }
}
