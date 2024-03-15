package dev.micfro.weeklyquikclyapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login-page";
    }


    @GetMapping("/log-access-denied")
    public String unauthorized() {
        return "log-access-denied";
    }
}
