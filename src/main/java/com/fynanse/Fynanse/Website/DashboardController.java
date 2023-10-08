package com.fynanse.Fynanse.Website;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("/")
    public String showHome(){
        boolean isUserSignedIn = false;
        if(isUserSignedIn){
            return "redirect:/dashboard";
        }
        else{
            return "redirect:/login";
        }
    }
    @GetMapping("/dashboard")
    public String showDashboard(){
        return "dashboard";
    }
}