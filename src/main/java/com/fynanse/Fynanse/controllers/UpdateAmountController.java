package com.fynanse.Fynanse.controllers;

import com.fynanse.Fynanse.models.User;
import com.fynanse.Fynanse.models.Account;
import com.fynanse.Fynanse.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
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
public class UpdateAmountController {
    @Autowired
    private UserService userService;
    static boolean isSpending;
    //for dynamic changes to the html
    @GetMapping(value={"/deposit", "/withdraw"})
    public String showUpdatePage(Model model, HttpServletRequest request){
        String uri = request.getRequestURI();
        if(uri.equals("/deposit")){
            model.addAttribute("updateTitle", "Deposit Amount");
            isSpending = false;
        }
        else if(uri.equals("/withdraw")){
            model.addAttribute("updateTitle", "Withdraw Amount");
            isSpending = true;
        }
        return "updateBalance";
    }
    @RequestMapping(value = "/updateAmount", method = RequestMethod.POST)
    public String updateCurrentAmount(@ModelAttribute("amount") double amount, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes){
        //getting the user
        Optional<User> currentUser = userService.getCurrentUser(request);
        if(currentUser.isPresent()){
            //getting the account
            Account currentUserAccount = userService.getAccount(currentUser.get().getUsername());
            if(isSpending){
                //updating balances
                double spendAmount = currentUserAccount.getCurrentBalance() - amount;
                //won't let the user spend more than what is available
                if(spendAmount < 0){  //negative
                    redirectAttributes.addFlashAttribute("errorMessage", "You can not withdraw more than you have available");
                    return "redirect:/withdraw";
                }
                currentUserAccount.setCurrentBalance(spendAmount);
                currentUserAccount.setLastSpent(amount);
                currentUserAccount.setWeeklySpent(currentUserAccount.getWeeklySpent()+amount);
                currentUserAccount.setMonthlySpent(currentUserAccount.getMonthlySpent()+amount);
                userService.saveAccountInfo(currentUserAccount);
            }
            else{
                currentUserAccount.setCurrentBalance(currentUserAccount.getCurrentBalance() + amount);
                currentUserAccount.setInitialBalance(currentUserAccount.getInitialBalance() + amount);
                userService.saveAccountInfo(currentUserAccount);
            }
        }
        else{
            return "redirect:/login";
        }
        return "redirect:/dashboard";
    }
}