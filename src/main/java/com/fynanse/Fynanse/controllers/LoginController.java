package com.fynanse.Fynanse.controllers;

import com.fynanse.Fynanse.models.User;
import com.fynanse.Fynanse.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("currentUser")
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping(path="/loginFormHandle", method = RequestMethod.POST)
    public String loginFormHandle(
            @ModelAttribute("username") String inputUsername,
            @ModelAttribute("userPassword") String inputPassword,
            HttpServletRequest request,
            RedirectAttributes redirectAttributes) {
        //validating the user manually because that's totally safe to do :)
        Optional<User> storedUser = userService.getUserById(inputUsername);
        //sending error messages to the html
        if (storedUser.isEmpty()) {
            String msg = "Username was not found. Would you like to ";
            redirectAttributes.addFlashAttribute("USERNAME_NOT_FOUND", msg);
            return "redirect:/login";
        }
        if (storedUser.get().getUserPassword().equals(inputPassword)) {
            //creating a persistent session for the user if credentials match
            HttpSession session = request.getSession();
            session.setAttribute("currentUsername", storedUser.get().getUsername());
            return "redirect:/dashboard";
        } else {
            String msg = "Password does not match. Please try again";
            redirectAttributes.addFlashAttribute("PASSWORD_INCORRECT", msg);
            return "redirect:/login";
        }
    }
}