package com.fynanse.Fynanse.Website;

import com.fynanse.Fynanse.api.models.User;
import com.fynanse.Fynanse.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Optional;

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
        model.addAttribute("currentUser", currentUser.get());
        return "dashboard";
    }
}