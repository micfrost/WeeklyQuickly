
package dev.micfro.weeklyquikclyapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/customer")
    public String customer() {
        return "customer";
    }

    @GetMapping("/employee")
    public String employee() {
        return "employee";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/secret/admin";
    }

    @GetMapping("/admin-dashbord")
    public String admindashbord() {
        return "/admin-dashbord";
    }


}
