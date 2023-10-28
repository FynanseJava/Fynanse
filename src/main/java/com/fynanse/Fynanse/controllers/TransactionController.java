package com.fynanse.Fynanse.controllers;

import com.fynanse.Fynanse.models.User;
import com.fynanse.Fynanse.services.TransactionService;
import com.fynanse.Fynanse.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private UserService userService;

    @GetMapping("/history")
    public String showHistory(HttpServletRequest request, Model model){
        Optional<User> currentUser = userService.getCurrentUser(request);
        if(currentUser.isEmpty()){
            return "redirect:/login";
        }
        model.addAttribute("transactionSet", transactionService.getAllTransactions(currentUser.get().getUsername()));
        return "history";
    }
}
