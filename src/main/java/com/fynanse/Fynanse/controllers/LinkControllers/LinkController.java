package com.fynanse.Fynanse.controllers.LinkControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LinkController {
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
    @GetMapping("/error")
    public String showErrorPage(){
        return "error";
    }
    @GetMapping("/settings")
    public String showSettings(){
        return "settings";
    }
    @GetMapping("/about")
    public String showAboutPage() {
        return "about";
    }
}