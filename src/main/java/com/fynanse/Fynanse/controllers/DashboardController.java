package com.fynanse.Fynanse.controllers;

import com.fynanse.Fynanse.models.Account;
import com.fynanse.Fynanse.models.User;
import com.fynanse.Fynanse.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Month;
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
        //So the user can not directly access the /dashboard without creating a session first
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
        //So the user can not directly access the /dashboard without creating a session first
        if(currentUser.isEmpty()) {
            return "redirect:/login";
        }
        //rendering dynamic attributes to the ModelView
        Account account = currentUser.get().getAccount();

        //Time calculations
		LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
        LocalDate lastDayOfMonth = firstDayOfMonth.plusMonths(1).minusDays(1);
        long daysRemaining = ChronoUnit.DAYS.between(today, lastDayOfMonth);
        Month thisMonth = today.getMonth();
        Month nextMonth = thisMonth.plus(1);
        int weeksRemaining = (int) ChronoUnit.WEEKS.between(today, lastDayOfMonth);

        //calculating days remaining and daily budget
        double dailyBudget = account.getCurrentBalance() / daysRemaining;

        //calculating current percentage and lastspent percentage
        double percentage = (account.getCurrentBalance() / account.getInitialBalance())*100;
        double diffPercentage = (account.getLastSpent()/ account.getInitialBalance())*100;
        double dailyBudgetPercentage = percentage / daysRemaining;
        double weeklySpentPercentage = (account.getWeeklySpent() / account.getInitialBalance()) * 100;
        double weeklyBudgetPercentage = percentage / weeksRemaining;

        //modeling everything
        model.addAttribute("firstName", currentUser.get().getFirstName());
        model.addAttribute("lastName", currentUser.get().getLastName());

        model.addAttribute("lastSpent", account.getLastSpent());
        model.addAttribute("currentBalance", account.getCurrentBalance());
        model.addAttribute("spentLastWeek", account.getWeeklySpent());
        model.addAttribute("spentLastMonth", account.getMonthlySpent());

        model.addAttribute("thisMonth", thisMonth.toString().substring(0, 3));
        model.addAttribute("nextMonth", nextMonth.toString().substring(0, 3));

        model.addAttribute("dailyBudgetPercentage", dailyBudgetPercentage);
        model.addAttribute("daysRemaining", daysRemaining);
        model.addAttribute("dailyBudget", dailyBudget);

        model.addAttribute("weeklyBudgetPercentage", weeklyBudgetPercentage);
        model.addAttribute("weeklySpentPercentage", weeklySpentPercentage);

        model.addAttribute("remainingBalancePercentage", percentage);
        model.addAttribute("diffPercentage", diffPercentage);
        return "dashboard";
    }
}