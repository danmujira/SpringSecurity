package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {
    @GetMapping("/")
    public String getMain(ModelMap model) {
        model.addAttribute("message", "Hello Spring Security");
        return "index";
    }

    @GetMapping("/user")
    public String getUserMain(ModelMap model, Principal principal) {
        model.addAttribute("message", "Hello User," );
        return "user";
    }

    @GetMapping("/admin")
    public String getAdminMain(ModelMap model, Principal principal) {
        model.addAttribute("message", "Hello Admin,");
        return "admin";
    }

}
