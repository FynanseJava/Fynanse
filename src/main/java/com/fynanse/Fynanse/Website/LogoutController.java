package com.fynanse.Fynanse.Website;

import com.fynanse.Fynanse.api.models.User;
import com.fynanse.Fynanse.api.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class LogoutController {
    @Autowired
    private UserService userService;
    @GetMapping("/logout")
    public String userLogout(HttpServletRequest request){
        Optional<User> currentUser = userService.getCurrentUser(request);
        if(currentUser.isEmpty()){
            return "redirect:/login";
        }
        HttpSession session = request.getSession();
        session.setAttribute("currentUser", new User());
        userService.updateUser(currentUser.get());
        return "redirect:/login";
    }
}