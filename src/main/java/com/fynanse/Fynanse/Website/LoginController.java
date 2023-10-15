package com.fynanse.Fynanse.Website;

import com.fynanse.Fynanse.api.models.User;
import com.fynanse.Fynanse.api.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes("currentUser")
public class LoginController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping(path="/loginFormHandle", method = RequestMethod.POST)
    public String loginFormHandle(@ModelAttribute("username") String inputUsername, @ModelAttribute("userPassword") String inputPassword, HttpServletRequest request) {
        //validating the user manually because that's totally safe to do :)
        Optional<User> storedUser = userService.getUserById(inputUsername);
        if (storedUser.isEmpty()) {
            return "redirect:/login";
        }
        if (storedUser.get().getUserPassword().equals(inputPassword)) {
            HttpSession session = request.getSession();
            session.setAttribute("currentUsername", storedUser.get().getUsername());
            return "redirect:/dashboard";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/error")
    public String showErrorPage(){
        return "error";
    }
}