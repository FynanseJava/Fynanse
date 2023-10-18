package com.fynanse.Fynanse.controllers;

import com.fynanse.Fynanse.models.Account;
import com.fynanse.Fynanse.models.User;
import com.fynanse.Fynanse.repositories.AccountRepository;
import com.fynanse.Fynanse.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class SettingsController {

    @Autowired
    private UserService userService;
    @Autowired
    private AccountRepository accountRepository;
    @GetMapping("/settings")
    public String showSettings(Model model, HttpServletRequest request){
        Optional<User> currentUser = userService.getCurrentUser(request);
        if (currentUser.isEmpty()){
            return "redirect:/login";
        }
        model.addAttribute("currentUser", currentUser.get());
        return "settings";
    }
    @RequestMapping(path = "/updateUserInfo", method = {RequestMethod.PUT, RequestMethod.POST})
    public String updateUserInfo(
            HttpServletRequest request,
//            @ModelAttribute("updatedFirstName") String updatedFirstName,
//            @ModelAttribute("updatedLastName") String updatedLastName
            @ModelAttribute("currentUser") User updatedUser
            ){
        Optional<User> currentUser = userService.getCurrentUser(request);
        if(currentUser.isEmpty()){
            return "redirect:/login";
        }
        currentUser.get().setFirstName(updatedUser.getFirstName());
        currentUser.get().setLastName(updatedUser.getLastName());
        userService.updateUser(currentUser.get().getUsername(), currentUser.get());
        accountRepository.save(currentUser.get().getAccount());
        return "redirect:/dashboard";
    }

    @RequestMapping(path = "/deleteCurrentUser", method = {RequestMethod.DELETE, RequestMethod.POST})
    public String deleteCurrentUser(HttpServletRequest request){
        Optional<User> currentUser = userService.getCurrentUser(request);
        if(currentUser.isEmpty()){
            return "redirect:/login";
        }
        userService.deleteUser(currentUser.get());
        return "redirect:/login";
    }
}