package com.fynanse.Fynanse.controllers;

import com.fynanse.Fynanse.models.Account;
import com.fynanse.Fynanse.models.User;
import com.fynanse.Fynanse.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Controller
public class DashboardController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String showHome(HttpServletRequest request){
        Optional<User> currentUser = userService.getCurrentUser(request);
        if(currentUser.isPresent()){
            return "redirect:/dashboard";
        }
        else{
            return "redirect:/login";
        }
    }
    @GetMapping("/dashboard")
    public String showDashboard(Model model, HttpServletRequest request){
        Optional<User> currentUser = userService.getCurrentUser(request);
        if(currentUser.isEmpty()) {
            return "redirect:/login";
        }
        Account account = currentUser.get().getAccount();
        model.addAttribute("lastSpent", account.getLastSpent());
        model.addAttribute("currentBalance", account.getCurrentBalance());
        model.addAttribute("spentLastWeek", account.getWeeklySpent());
        model.addAttribute("spentLastMonth", account.getMonthlySpent());

		LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
        LocalDate lastDayOfMonth = firstDayOfMonth.plusMonths(1).minusDays(1);

        long daysRemaining = ChronoUnit.DAYS.between(today, lastDayOfMonth);

        model.addAttribute("daysRemaining", daysRemaining);
        double percentage = (account.getCurrentBalance() / account.getInitialBalance())*100;
        model.addAttribute("remainingBalancePercentage", percentage);
        model.addAttribute("firstName", currentUser.get().getFirstName());
        model.addAttribute("lastName", currentUser.get().getLastName());
        return "dashboard";
    }
}