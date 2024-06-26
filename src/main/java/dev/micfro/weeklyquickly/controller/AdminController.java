package dev.micfro.weeklyquickly.controller;

import dev.micfro.weeklyquickly.model.Admin;
import dev.micfro.weeklyquickly.model.Authority;
import dev.micfro.weeklyquickly.model.User;
import dev.micfro.weeklyquickly.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {


    AdminService adminService;
    PasswordEncoder passwordEncoder;

    @Autowired
    public AdminController(PasswordEncoder passwordEncoder, AdminService adminService) {
        this.passwordEncoder = passwordEncoder;
        this.adminService = adminService;
    }

    @GetMapping("/admin-list")
    public String listAdmins(Model model) {
        model.addAttribute("admins", adminService.findAll());
        return "admin-list";
    }

    @GetMapping("/admin-form")
    public String showAdminForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "admin-form";
    }

    @PostMapping("/add-admin")
    public String addAdmin(@ModelAttribute("admin") Admin admin) {
        // PasswordEncoder
        User user = admin.getUser();
        user.setAdmin(admin);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setAuthority(new Authority(user.getUsername(), admin.getRole()));

        // Save Admin
        adminService.saveAdmin(admin);


        return "redirect:/admin-list";
    }
}
