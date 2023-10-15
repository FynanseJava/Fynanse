package com.fynanse.Fynanse.controllers;

import com.fynanse.Fynanse.models.Account;
import com.fynanse.Fynanse.models.User;
import com.fynanse.Fynanse.repositories.AccountRepository;
import com.fynanse.Fynanse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class SignupController {
    @Autowired
    private UserService userService;
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/signup")
    public String showSignUp(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }
    @RequestMapping(path = "/signUpFormHanlde", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user, @ModelAttribute("startingBalance") double amount, RedirectAttributes redirectAttributes){
        Optional<User> u = userService.getUserById(user.getUsername());
        if(u.isPresent()){
            String msg = "Username already taken. Please try another username.";
            redirectAttributes.addFlashAttribute("USERNAME_EXISTS", msg);
            return "redirect:/signup";
        }
        Account newAccount = new Account();
        newAccount.setCurrentBalance(amount);
        newAccount.setInitialBalance(amount);
        user.setAccount(newAccount);
        accountRepository.save(newAccount);
        userService.addUser(user);
        return "redirect:/login";
    }

}