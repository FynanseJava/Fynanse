package com.fynanse.Fynanse.controllers;

import com.fynanse.Fynanse.models.Account;
import com.fynanse.Fynanse.models.User;
import com.fynanse.Fynanse.repositories.AccountRepository;
import com.fynanse.Fynanse.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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

    //getting the User
    @GetMapping("/signup")
    public String showSignUp(Model model){
        User user = new User();
        model.addAttribute("newUser", user);
        return "signup";
    }
    @RequestMapping(path = "/signUpFormHanlde", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User newUser, @ModelAttribute("startingBalance") double amount, RedirectAttributes redirectAttributes, HttpServletRequest request){
        Optional<User> u = userService.getUserById(newUser.getUsername());
        //seeing if a user with the same username exists or not
        if(u.isPresent()){
            String msg = "Username already taken. Please try another username.";
            redirectAttributes.addFlashAttribute("USERNAME_EXISTS", msg);
            return "redirect:/signup";
        }
        //creating and saving account for user
        Account newAccount = new Account();
        newAccount.setCurrentBalance(amount);
        newAccount.setInitialBalance(amount);
        newUser.setAccount(newAccount);
        accountRepository.save(newAccount);
        userService.addUser(newUser);
        //logging in the user upon signup without login
        HttpSession session = request.getSession();
        session.setAttribute("currentUsername", newUser.getUsername());
        return "redirect:/dashboard";
    }

}