package com.fynanse.Fynanse.Website;

import com.fynanse.Fynanse.api.models.User;
import com.fynanse.Fynanse.api.models.Account;
import com.fynanse.Fynanse.api.services.UserService;
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
public class UpdateAmountController {
    @Autowired
    private UserService userService;
    static boolean isSpending;
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
    public String updateCurrentAmount(@ModelAttribute("amount") double amount, Model model){
        Optional<User> currentUser = userService.getCurrentUser();
        if(currentUser.isPresent()){
            Account currentUserAccount = userService.getAccount(currentUser.get().getUsername());
            if(isSpending){
                currentUserAccount.setCurrentBalance(currentUserAccount.getCurrentBalance() - amount);
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