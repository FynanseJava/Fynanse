package com.fynanse.Fynanse.Website;

import com.fynanse.Fynanse.api.models.Account;
import com.fynanse.Fynanse.api.models.User;
import com.fynanse.Fynanse.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class DashboardController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String showHome(){
        Optional<User> currentUser = userService.getCurrentUser();
        if(currentUser.isPresent()){
            return "redirect:/dashboard";
        }
        else{
            return "redirect:/login";
        }
    }
    @GetMapping("/dashboard")
    public String showDashboard(Model model){
        Optional<User> currentUser = userService.getCurrentUser();
        if(currentUser.isEmpty()) {
            return "redirect:/login";
        }
        Account account = currentUser.get().getAccount();
        model.addAttribute("lastSpent", account.getLastSpent());
        model.addAttribute("currentBalance", account.getCurrentBalance());
        model.addAttribute("spentLastWeek", account.getWeeklySpent());
        model.addAttribute("spentLastMonth", account.getMonthlySpent());

        Calendar today = Calendar.getInstance();
        // Get the first day of the next month.
        Calendar firstDayOfNextMonth = Calendar.getInstance();
        firstDayOfNextMonth.set(firstDayOfNextMonth.get(Calendar.YEAR), firstDayOfNextMonth.get(Calendar.MONTH) + 1, 1);
        // Calculate the difference between the current date and the first day of the next month.
        long daysRemaining = today.get(Calendar.DAY_OF_MONTH) - firstDayOfNextMonth.get(Calendar.DAY_OF_MONTH);
        //TODO: days remaining is outputing wrong info. Need to fix that

        model.addAttribute("daysRemaining", daysRemaining);
        double percentage = (account.getCurrentBalance() / account.getInitialBalance())*100;
        model.addAttribute("remainingBalancePercentage", percentage);
        model.addAttribute("firstName", currentUser.get().getFirstName());
        model.addAttribute("lastName", currentUser.get().getLastName());
        return "dashboard";
    }
}